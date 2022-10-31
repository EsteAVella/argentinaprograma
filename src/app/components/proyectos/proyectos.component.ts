import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { Validators, FormGroup } from '@angular/forms';
import { faTrash, faPencil, faXmark } from '@fortawesome/free-solid-svg-icons';
import { PortfolioService } from '../../service/portfolio.service';
import { Subscription } from 'rxjs';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { FormBuilder } from '@angular/forms';
import { Proyecto } from 'src/app/config/Proyecto';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  faTrash = faTrash;
  faXmark=faXmark;
  faPencil = faPencil;
  @Output() btnClick = new EventEmitter();
  showAddTask4:boolean = false;
  proyectoList: Proyecto[] = [];
  isUserLogged: Boolean = false ;
  proyectoForm: FormGroup;
  subscription4?: Subscription;
  editForm: any;
  idUser: number;
  isEdicion4:boolean;

  constructor(private portfolioService: PortfolioService,
    private autenticacionService: AutenticacionService,
    private formBuilder: FormBuilder) { 
      this.subscription4  = this.portfolioService.onToggle4().subscribe(value => this.showAddTask4 = value);
      this.proyectoList   = this.autenticacionService.UsuarioAutenticado?.proyectos || [];
      this.idUser         = this.autenticacionService.idUser();
      this.isEdicion4     = false;
      this.proyectoForm   = this.formBuilder.group({
        id:        [''],
        nombre:    ['',[Validators.required]],
        fecha:     [''],
        link:      [''],
        usuario_id:[this.idUser],

      })
    }

  ngOnInit(): void {
    this.isUserLogged=this.autenticacionService.isUserLogged();
    // this.reloadData();
    console.log(this.proyectoList);
  }

  private reloadData(){
    this.portfolioService.obtenerProyecto( this.idUser ).subscribe(( data )=>{
      this.proyectoList = data;
    });
  }
  private clearForm(){
    this.proyectoForm.setValue({
      id:'',
      nombre:'',
      fecha:'',
      usuario_id:this.idUser,
      link:'',
 
    })
  }

  private loadForm(proyecto : Proyecto){
    this.proyectoForm.setValue({
      id:           proyecto.id,
      usuario_id:   this.idUser,
      nombre:       proyecto.nombre,
      fecha:        proyecto.fecha,
      link:         proyecto.link,

    })
  }
  onSubmit(){
    let proyecto : Proyecto = this.proyectoForm.value;
    if(!this.isEdicion4){
      this.portfolioService.crearProyecto( proyecto ).subscribe(
        (newProyecto : Proyecto) =>{
          this.reloadData();
        }
      );
    }else{
      this.portfolioService.modificarProyecto( proyecto ).subscribe(
          () => {
          
          this.reloadData();
          }
      ) 
    }
    this.onNewProyecto()
  }
  onNewProyecto() {
    this.isEdicion4=false;
    this.clearForm();
    this.portfolioService.toggleAddTask4();
    } 
    onEditProyecto(index: number) {
      this.isEdicion4 = true;
       let proyecto:Proyecto= this.proyectoList[index];
       this.portfolioService.toggleAddTask4();
       this.loadForm( proyecto );
      
    }

     onDeleteProyecto(index: number) {
      let proyecto : Proyecto = this.proyectoList[index];
      if (confirm("¿Está seguro que desea borrar el proyecto seleccionado?")) {
        this.portfolioService.borrarProyecto(proyecto.id).subscribe(
          () => {
            this.reloadData();
          }
        )
      }
    }

      toggleAddTask4(){
        this.onNewProyecto() ;
       
      }
    
}
