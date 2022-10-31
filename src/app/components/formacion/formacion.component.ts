import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { Validators, FormGroup } from '@angular/forms';
import { faTrash, faPencil, faXmark, faPlus } from '@fortawesome/free-solid-svg-icons';
import { PortfolioService } from '../../service/portfolio.service';
import { Subscription } from 'rxjs';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { FormBuilder } from '@angular/forms';
import { Educacion } from '../../config/Educacion';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-formacion',
  templateUrl: './formacion.component.html',
  styleUrls: ['./formacion.component.css']
})
export class FormacionComponent implements OnInit {
  headers: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  });

  faTrash   = faTrash;
  faXmark   = faXmark;
  faPencil  = faPencil;
  faPlus    = faPlus;

  @Output() btnClick = new EventEmitter();
  
  files:          File[] = [];
  showAddTask:    boolean = false;
  educacionList:  Educacion[] = [];
  isUserLogged:   Boolean = false ;
  educacionForm:  FormGroup;
  subscription?:  Subscription;
  editForm:       any;
  idUser:         number;
  isEdicion:      boolean;
  
  constructor(
    private portfolioService:      PortfolioService,
    private autenticacionService:  AutenticacionService,
    private formBuilder:           FormBuilder) {
      
      this.subscription  = this.portfolioService.onToggle().subscribe( value => this.showAddTask = value );
      this.educacionList = this.autenticacionService.UsuarioAutenticado?.educacion || [];
      this.idUser        = this.autenticacionService.idUser();
      this.isEdicion     = false;
      
      this.educacionForm = this.formBuilder.group({
        
        id:           [''],
        school:       ['',[Validators.required]],
        fechaI:       [''],
        score:        [''],
        fechaF:       [''],
        title:        [''],
        usuario_id:   [this.idUser],
      })
    }

    ngOnInit(): void {
      this.isUserLogged = this.autenticacionService.isUserLogged();
      // this.reloadData();
      
    }
    private reloadData(){
      this.portfolioService.obtenerEducacion( this.idUser ).subscribe(( data )=>{
        this.educacionList = data;
      });
  }

  private clearForm(){
    this.educacionForm.setValue({
      id      :'',
      school  :"",   
      fechaI  :"",   
      fechaF  :"",   
      title   :"",   
      score   :"",
      usuario_id:this.idUser,
    })
  }
  private loadForm(educacion : Educacion ){
    this.educacionForm.setValue({
      id:                educacion.id,
      school:            educacion.school,
      fechaF:            educacion.fechaF,
      fechaI:            educacion.fechaI,
      title:             educacion.title,
      score:             educacion.score,
      usuario_id:        educacion.usuario_id,
    })
  }

  onSubmit(){
    let educacion : Educacion = this.educacionForm.value;
    if(!this.isEdicion){
      this.portfolioService.crearEducacion( educacion ).subscribe(
        ( newEducacion : Educacion ) =>{
        
          this.reloadData();
        }
      );
    }else{
      this.portfolioService.modificarEducacion( educacion ).subscribe(
          () => {
          console.log(educacion)
          this.reloadData();
          }
      ) 
    }
    this.onNewEducacion()
  }

  onNewEducacion() {
    this.isEdicion=false;
    this.clearForm();
    this.portfolioService.toggleAddTask();
    } 

  onEditEducacion(index: number) {
    this.isEdicion = true;
    let educacion: Educacion = this.educacionList[index];
    this.portfolioService.toggleAddTask();
    this.loadForm(educacion);
   
  }

  onDeleteEducacion(index: number) {
    let educacion: Educacion = this.educacionList[index];
    if (confirm("¿Está seguro que desea borrar la educación seleccionada?")) {
      this.portfolioService.borrarEducacion(educacion.id).subscribe(
        () => {
          this.reloadData();
        }
      )
    }
  }

    toggleAddTask(){
      this.onNewEducacion() ;
     
    }

    onSelect(event:any) {
      console.log(event);
      this.files.push(...event.addedFiles);
    }
    
    onRemove(event:any) {
      console.log(event);
      this.files.splice(this.files.indexOf(event), 1);
      this.educacionForm.value.img = null;
    }
    
    onUpload(){
      const file_data = this.files[0];
      const data = new FormData();
    
      data.append('file',file_data);
      data.append('upload_preset','perfil.foto')
      data.append('cloud_name','duooheafl')
      data.set("secure", 'true')
    
      this.portfolioService.uploadImage(data).subscribe((response)=>{
        if(response){
        console.log(response)}
       this.educacionForm.value.img = response.secure_url;

      })
    
      
    
    }

}


