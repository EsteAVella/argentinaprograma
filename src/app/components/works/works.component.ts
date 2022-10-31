import { Component, OnInit } from '@angular/core';
import { Validators, FormGroup } from '@angular/forms';
import { faTrash, faPencil, faXmark } from '@fortawesome/free-solid-svg-icons';
import { Experiencia } from 'src/app/config/Experiencia';
import { PortfolioService } from '../../service/portfolio.service';
import { Subscription } from 'rxjs';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { FormBuilder } from '@angular/forms';


@Component({
  selector: 'app-works',
  templateUrl: './works.component.html',
  styleUrls: ['./works.component.css']
})
export class WorksComponent implements OnInit {

  faTrash   = faTrash;
  faXmark   = faXmark;
  faPencil  = faPencil;

  experienciaList: Experiencia[] = [];
  showAddTask2:     boolean       = false;
  isUserLogged:     Boolean       = false;
  isEdicion2:       boolean;
  experienciaForm:  FormGroup;
  subscription2?:   Subscription;
  editForm:         any;
  idUser:           number;

  
  constructor(
    private portfolioService:     PortfolioService,
    private autenticacionService: AutenticacionService,
    private formBuilder:          FormBuilder) {
      this.subscription2    = this.portfolioService.onToggle2().subscribe(value => this.showAddTask2 = value);
      this.experienciaList  = this.autenticacionService.UsuarioAutenticado?.experiencia || [];
      this.idUser           = this.autenticacionService.idUser();
      this.isEdicion2       = false;
      this.experienciaForm = this.formBuilder.group({
        id:             [''],
        empresa:        ['',[Validators.required]],
        descripcion:    ['',[Validators.required]],
        puesto:         [''],
        inicio:         ['',[Validators.required]],
        fin:            [''],
        usuario_id:     [this.idUser],
        trabajo_actual:  [''],
      })
    }

  ngOnInit(): void {
    this.isUserLogged = this.autenticacionService.isUserLogged();
    // this.reloadData();
    console.log(this.experienciaList.length);
  }
  private reloadData(){
    this.portfolioService.obtenerExperiencia( this.idUser ).subscribe(( data )=>{
      this.experienciaList = data;
    });
}

private clearForm(){
  this.experienciaForm.setValue({
    id:'',
    empresa:'',
    puesto:'',
    descripcion:'',
    inicio:'',
    fin:'',
    trabajo_actual:'',
    usuario_id:this.idUser,
  })
}
//modificar la tabla
private loadForm( experiencia : Experiencia ){
  this.experienciaForm.setValue({
    
    id:                experiencia.id,
    empresa:            experiencia.empresa,
    puesto:             experiencia.puesto,
    descripcion:        experiencia.descripcion,
    inicio:             experiencia.inicio,
    fin:                experiencia.fin,
    trabajo_actual:     experiencia.trabajoActual,
    usuario_id:         experiencia.usuario_id,
  })
}



onSubmit(){
  let experiencia : Experiencia = this.experienciaForm.value;
  if(!this.isEdicion2){
  
    this.portfolioService.crearExperiencia(experiencia).subscribe(
      (newExperiencia : Experiencia) =>{
       
        this.reloadData();
      }
    );
  }else{
    this.portfolioService.modificarExperiencia(experiencia).subscribe(
        () => {
        
        this.reloadData();
        }
    ) 
  }
  this.onNewExpLaboral()
}

onNewExpLaboral() {
  this.isEdicion2=false
  this.clearForm();
  this.portfolioService.toggleAddTask2();
  } 

  onEditExpLaboral( index: number ) {
    this.isEdicion2 = true;
    let experiencia : Experiencia = this.experienciaList[index];
    this.portfolioService.toggleAddTask2();
    this.loadForm(experiencia);
  }

  onDeleteExpLaboral( id : number ) {
    
    if (confirm("¿Está seguro que desea borrar la experiencia seleccionada?")) {
      this.portfolioService.borrarExperiencia( id ).subscribe(
        
        () => {
          this.reloadData();
        }
      )
    }
  }

    toggleAddTask2(){
      this.onNewExpLaboral() ;
    }

}
