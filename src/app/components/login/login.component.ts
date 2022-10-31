import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,Form } from '@angular/forms';
import { AutenticacionService } from 'src/app/service/autenticacion.service';
import { Persona } from '../../config/PersonaDto';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  form: FormGroup;
  // formularioCreado:FormGroup;
  loginError: Boolean = false;

  constructor(
    private formBuilder : FormBuilder,
    private authService: AutenticacionService,
    private router: Router
  
  ) {
      this.form = this.formBuilder.group({
      
        email   :["",Validators.compose([Validators.required,Validators.email])],
        password :["",Validators.compose([Validators.required,Validators.minLength(5)])]

      });

  }
  ngOnInit(): void {
  }

  onLogin(){
    if ( Response ){
      this.router.navigate(['/login'])};
  }
  
  onSubmit( event: Event ) {
    event.preventDefault;

    this.authService.loginUser(this.form.value).subscribe(
      (response: Boolean) => {
        if (response)
          this.router.navigate(['/home']);
        else
          this.loginError = true;
      }
    );
  }

  
  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }
  // onEnviar(){
  //   this.authService.loginUser( this.formularioCreado.value ).subscribe(
  //     ( response: Persona ) => {
  //       if ( response ){
  //         this.router.navigate(['/home'])}
  //     }
  //   );
  // }
}

