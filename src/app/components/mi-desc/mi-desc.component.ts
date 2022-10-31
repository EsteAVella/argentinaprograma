import { Component, OnInit } from '@angular/core';
import { faTrash,faPencil,faXmark } from '@fortawesome/free-solid-svg-icons';
import { Subscription } from 'rxjs';
import { Persona } from 'src/app/config/PersonaDto';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { FormGroup, FormBuilder,Validators,Form } from '@angular/forms';
  



@Component({
    selector: 'app-mi-desc',
    templateUrl: './mi-desc.component.html',
    styleUrls: ['./mi-desc.component.css']
  })
  export class MiDescComponent implements OnInit {
  
    faTrash   = faTrash;
    faXmark   = faXmark;
    faPencil  = faPencil;
    
    files           : File[] = [];
    persona         : Persona;
    isUserLogged    : Boolean ;
    personaForm     : FormGroup;
    idUser          : number;
    isEdicion5      : boolean;
    showAddTask5    : boolean = false;
    subscription5?  : Subscription;
    imgURL          : any;
    imagePath       : any;
    constructor( 
      private portfolioService      : PortfolioService,
      private autenticacionService  : AutenticacionService,
      private formBuilder           : FormBuilder) { 
        this.persona        = autenticacionService.UsuarioAutenticado;
        this.isUserLogged   = autenticacionService.isUserLogged();
        this.idUser         = this.autenticacionService.idUser();
        this.subscription5  = this.portfolioService.onToggle().subscribe(value => this.showAddTask5 = value);
        this.isEdicion5     = false;
        this.personaForm    = this.formBuilder.group ({
          id:          [this.idUser],
          nombre:      [''],
          apellido:    [''],
          email:       [''],
          carrera:     [''],
          foto:        [''],
          descripcion: [''],
          password:    [''],
          banner:      [''],
        })
    }
  
    ngOnInit(): void {
      this.isUserLogged=this.autenticacionService.isUserLogged();
      this.reloadData();
      console.log(this.personaForm.value)
    
    }
  
    private reloadData(){
      this.portfolioService.findPersona( this.idUser ).subscribe(( data )=>{
        this.persona= data;
      });
     
  }
  
  private loadForm( persona : Persona ){
    this.personaForm.setValue({
      id:           this.idUser,
      nombre:       persona.nombre,
      apellido:     persona.apellido,
      email:        persona.email,
      banner:       persona.banner,
      carrera:      persona.carrera,
      foto:         persona.foto,
      descripcion:  persona.descripcion,
      password:     persona.password
  
    })
  }
    onSubmit(){
    
      let persona : Persona = {...this.persona,...this.personaForm.value}
    
    
    this.portfolioService.editPersona( persona ).subscribe(
      () => {
        
      this.reloadData();
      }
  ) 
  
    this.isEdicion5 = false
  }
  
  onEditUser() {
    this.isEdicion5         = true
    let persona: Persona    = this.persona
    this.loadForm(persona)
  }
  

  onSelect(event:any) {
    console.log(event);
    this.files.push(...event.addedFiles);
  }
  
  onRemove(event:any) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
  }
  
  onUpload(){
    
    const file_data = this.files[0];
    const data = new FormData();
  
    data.append('file',file_data);
    data.append('upload_preset','perfil.foto')
    data.append('cloud_name','duooheafl')
    data.set   ("secure", 'true')
  
    this.portfolioService.uploadImage(data).subscribe(( response )=>{
      if( response ){
      console.log( response )}
     this.personaForm.value.foto = response.secure_url;
    
        
    })
  
    
  
  }
  }