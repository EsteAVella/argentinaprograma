import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { GuardGuard } from './service/guard.guard';


const routes: Routes = [
  {path:'home',component:HomeComponent,canActivate:[GuardGuard]},
  {path:'login',component: LoginComponent, pathMatch:"full",canActivate:[GuardGuard]},
  {path:'',redirectTo:'login',pathMatch:'full'} 
  ];
  // {path: '', component: HomeComponent},
  // {path: 'login', component: LoginComponent}
// ];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
