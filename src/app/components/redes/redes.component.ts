import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faTrash,faPencil,faPlus, faTurkishLiraSign } from '@fortawesome/free-solid-svg-icons';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder,Validators,Form } from '@angular/forms';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { Redes } from 'src/app/config/Redes';

@Component({
  selector: 'app-redes',
  templateUrl: './redes.component.html',
  styleUrls: ['./redes.component.css']
})
export class RedesComponent implements OnInit {
  
  faPencil= faPencil;
  faPlus=faPlus;

  files:      File[] = [];
  redesList:  Redes[] = [];
  
  showAddTask6:     boolean = false;
  isUserLogged:     Boolean = false ;
  isEdicion6:       boolean;
  redes!:           Redes;
  redesForm:        FormGroup;
  subscription6?:   Subscription;
  idUser:           number;

  constructor(
    private portfolioService:     PortfolioService,
    private autenticacionService: AutenticacionService,
    private formBuilder:          FormBuilder,
    private router:               Router){ 
      this.subscription6  = this.portfolioService.onToggle6().subscribe(value => this.showAddTask6 = value);
      this.redesList      = this.autenticacionService.UsuarioAutenticado?.redes || [];
      this.idUser         = this.autenticacionService.idUser();
      this.isEdicion6     = true;
    
      this.redesForm = this.formBuilder.group({
        id:         [''],
        usuario_id: [this.idUser],
        linked:     ['',[Validators.required]],
        git:        ['',[Validators.required]],
        face:       ['',Validators.required],
        insta:      ['',Validators.required],
        
      })
    }

    ngOnInit(): void {
      this.isUserLogged = this.autenticacionService.isUserLogged();
      this.reloadData();

    }
  
    private reloadData(){
    this.portfolioService.obtenerRedes(this.idUser).subscribe(( data )=>{
        this.redes = data;
        
        if(this.redes == null){
          this.isEdicion6 = false;
        }else{
          this.isEdicion6=true;
        }
      });
    }
  
    private loadForm( redes: Redes ){
      this.redesForm.setValue({
        
        usuario_id:   this.idUser,
        id:           redes.id,
        git:          redes.git,
        face:         redes.face,
        insta:        redes.insta,
        linked:       redes.linked
      })
  }
 

  onSubmit(){
    let redes: Redes = this.redesForm.value;
    if(!this.isEdicion6){
      this.portfolioService.crearRedes( redes ).subscribe(
        ( NewRedes : Redes) =>{
         
          this.reloadData();
        }
      );
    }else{
      this.portfolioService.modificarRedes(redes).subscribe(
          () => {
          console.log(redes)
          this.reloadData();
          }
      ) 
    }
    this.onNewRedes()
    this.isEdicion6 = true


  }
  private clearForm(){
    this.redesForm.setValue({
      id:'',
      persona:this.idUser,
      headder:'',
      insta:'',
      face:'' 
    })
  }

  logout() {
    this.autenticacionService.logout();
    this.isUserLogged = false;

    this.router.navigate(['/login'])
  
  }

  onNewRedes() {

    this.clearForm();
    this.portfolioService.toggleAddTask6();
    console.log(this.isEdicion6)

    } 
    onEditRedes(){
     console.log(this.redes)
      this.loadForm(this.redes)
      this.portfolioService.toggleAddTask6();
    }


    onSelect(event:any) {
      console.log(event);
      this.files.push(...event.addedFiles);
    }
    
    onRemove(event:any) {
      console.log(event);
      this.files.splice(this.files.indexOf(event), 1);
      this.redesForm.value.headder = null;
    }
    
    onUpload(){
      const file_data = this.files[0];
    
      const data = new FormData();
    
      data.append('file',file_data);
      data.append('upload_preset','perfil.foto')
      data.append('cloud_name','duooheafl')
      data.set("secure", 'true')
    
      this.portfolioService.uploadImage(data).subscribe((response)=>{
        if( response ){
        console.log( response )}
       this.redesForm.value.headder = response.secure_url;

      })
    
      
    
    }

}
