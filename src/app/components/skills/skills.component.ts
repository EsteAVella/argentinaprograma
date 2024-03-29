import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { FormGroup, FormBuilder,Validators,Form } from '@angular/forms';
import { Skill } from 'src/app/config/Skill';
import { PortfolioService } from 'src/app/service/portfolio.service';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { faTrash,faPencil,faXmark } from '@fortawesome/free-solid-svg-icons';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  
  faTrash = faTrash;
  faXmark = faXmark;
  faPencil = faPencil;

  @Output() btnClick = new EventEmitter();
  showAddTask3:   boolean = false;
  skillList:      Skill[] = [];
  isUserLogged:   Boolean = false ;
  skillForm:      FormGroup;
  subscription?:  Subscription;
  idUser:         number;
  isEdicion3:     boolean;
 
  constructor(
    private portfolioService: PortfolioService,
    private autenticacionService: AutenticacionService,
    private formBuilder: FormBuilder) {
    
      this.subscription   = this.portfolioService.onToggle3().subscribe(value => this.showAddTask3 = value);
      this.skillList      = this.autenticacionService.UsuarioAutenticado?.skill || [];
      this.idUser         = this.autenticacionService.idUser();
      this.isEdicion3     = false;
            
      this.skillForm = this.formBuilder.group({
        id:             [''],
        usuario_id:     [this.idUser],
        nombre:         ['',[Validators.required]],
        porcentaje:     ['',[Validators.required]]
      })
  }


  ngOnInit(): void {
    this.isUserLogged=this.autenticacionService.isUserLogged();
    this.reloadData();
  }
  private reloadData(){
    this.portfolioService.obtenerSkill(this.idUser).subscribe((data)=>{
      this.skillList= data;
    });
  }

  private clearForm(){
    this.skillForm.setValue({
      
      id            :'',
      usuario_id    :this.idUser,
      nombre        :'',
      porcentaje    :''
    
    })
  }

  private loadForm( skill : Skill ){
    this.skillForm.setValue({
      id:         skill.id,
      usuario_id: this.idUser,
      nombre:     skill.nombre,
      porcentaje: skill.porcentaje,
    
    })
}

onSubmit(){
  let skill: Skill = this.skillForm.value;
  if(!this.isEdicion3){
    this.portfolioService.crearSkill( skill ).subscribe(
      (newSkill : Skill) =>{
       
        this.reloadData();
      }
    );
  }else{
    this.portfolioService.modificarSkill( skill ).subscribe(
        () => {
        
        this.reloadData();
        }
    ) 
  }
  this.onNewSkill()
}

onNewSkill() {
  this.isEdicion3=false
  this.clearForm();
  this.portfolioService.toggleAddTask3();
  } 

  onEditSkill( index : number) {
    this.isEdicion3 = true;
    let skill : Skill = this.skillList[index];
    this.portfolioService.toggleAddTask3();
    this.loadForm(skill);
  }
  onDeleteSkill( index : number) {
    let skill : Skill = this.skillList[index];
    if (confirm("¿Está seguro que desea borrar la habilidad seleccionada?")) {
      this.portfolioService.borrarSkill(skill.id).subscribe(
        () => {
          this.reloadData();
        
        }
      )
    }
  }
  toggleAddTask3(){
    this.onNewSkill();
  }

 

}
