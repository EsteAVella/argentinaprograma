import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { config } from '../config/Config';
import { Educacion } from '../config/Educacion';
import { Persona } from '../config/PersonaDto';
import { Experiencia } from '../config/Experiencia';
import { Skill } from '../config/Skill';
import { Proyecto } from '../config/Proyecto';
import { Redes } from '../config/Redes';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {
  
  private showAddTask : boolean = false;
  private showAddTask2: boolean = false;
  private showAddTask3: boolean = false;
  private showAddTask4: boolean = false;
  private showAddTask5: boolean = false;
  private showAddTask6: boolean = false;
  
  private subject  = new Subject<any>();
  private subject2 = new Subject<any>();
  private subject3 = new Subject<any>();
  private subject4 = new Subject<any>();
  private subject5 = new Subject<any>();
  private subject6 = new Subject<any>();
  
  constructor(private http:HttpClient) { }

  obtenerEducacion( id : number ): Observable<any> {
    return this.http.get<any>(config.baseUrl + "educacion/" + id);
  }
  crearEducacion( educacion : Educacion ) : Observable<Educacion> {
    return this.http.post<any>(config.baseUrl + "educacion/create", educacion);
  }
  modificarEducacion( educacion : Educacion ) : Observable<any> {
    return this.http.put<any>(config.baseUrl + "educacion/update", educacion);
  }
  borrarEducacion( id : number ): Observable<any> {
    return this.http.delete<any>(config.baseUrl + "educacion/" + id);
  }
  
  
  obtenerExperiencia( id : number ) : Observable<Experiencia[]> {
    return this.http.get<Experiencia[]>(config.baseUrl + "experiencia/" + id);
  }
  crearExperiencia( experiencia : Experiencia ) : Observable<Experiencia> {
    return this.http.post<any>(config.baseUrl + "experiencia/create", experiencia);
  }
  modificarExperiencia( experiencia : Experiencia ): Observable<Experiencia[]> {
    return this.http.put<Experiencia[]>(config.baseUrl + "experiencia/update", experiencia);
  }
  borrarExperiencia( id: number ): Observable< any > {
    return this.http.delete< any >(config.baseUrl + "experiencia/" + id);
  }
  

  editPersona( persona : Persona ) : Observable< Persona >{
    return this.http.put<any>(config.baseUrl+"personas/editar/" + persona.id , persona );
  }
  findPersona( id : number ) : Observable<any>{
    return this.http.get<any>(config.baseUrl+"personas/traer/" + id );
  }
  savePersona(persona: Persona):Observable<Persona[]>{
    return this.http.post<Persona[]>(config.baseUrl + "User",persona)
  }
    
  
  obtenerSkill( id : number ) : Observable<any> {
    return this.http.get<any>(config.baseUrl + "skills/" + id);
  }
  crearSkill( skill : Skill ): Observable<Skill> {
    return this.http.post<any>(config.baseUrl + "skills/create", skill);
  }
  modificarSkill( skill : Skill ): Observable<any> {
    return this.http.put<any>(config.baseUrl + "skills/update",skill);
  }
  borrarSkill ( id : number ): Observable<any> {
    return this.http.delete<any>(config.baseUrl + "skills/" + id);
  }
  
  
  obtenerProyecto( id : number ): Observable<any> {
    return this.http.get<any>(config.baseUrl + "proyectos/" + id);
  }
  crearProyecto(proyecto : Proyecto): Observable<Proyecto> {
    return this.http.post<any>(config.baseUrl + "proyectos/create", proyecto);
  }
  modificarProyecto( proyecto : Proyecto): Observable<any> {
    return this.http.put<any>(config.baseUrl + "proyectos/update",proyecto);
  }
  borrarProyecto ( id : number ): Observable<any> {
    return this.http.delete<any>(config.baseUrl + "proyectos/" + id);
  }
  
  
  obtenerRedes(id:number): Observable<any> {
    return this.http.get<any>(config.baseUrl + "redes/" + id);
  }
  crearRedes(redes : Redes): Observable<Redes> {
    return this.http.post<any>(config.baseUrl + "redes/create", redes);
  }
  modificarRedes(redes : Redes): Observable<any> {
    return this.http.put<any>(config.baseUrl + "redes/update",redes);
  }

  toggleAddTask(): void {
    this.showAddTask = !this.showAddTask;
    this.subject.next(this.showAddTask);
  }
  
  onToggle(): Observable <any>{
    return this.subject.asObservable();
  }
  
  toggleAddTask2(): void {
        this.showAddTask2 = !this.showAddTask2;
        this.subject2.next(this.showAddTask2);
    }
  onToggle2(): Observable <any>{
        return this.subject2.asObservable();
    }

  toggleAddTask3(): void {
    this.showAddTask3 = !this.showAddTask3;
    this.subject3.next(this.showAddTask3);
    }
  onToggle3(): Observable <any>{
        return this.subject3.asObservable();
    }

  
  toggleAddTask4(): void {
    this.showAddTask4 = !this.showAddTask4;
    this.subject4.next(this.showAddTask4);
  }
  onToggle4(): Observable <any>{
    return this.subject4.asObservable();
  }

  
  toggleAddTask5(): void {
    this.showAddTask5 = !this.showAddTask5;
    this.subject5.next(this.showAddTask5);
  }

  onToggle5(): Observable <any>{
    return this.subject5.asObservable();
  }

  
  toggleAddTask6(): void {
    this.showAddTask6 = !this.showAddTask6;
    this.subject6.next(this.showAddTask6);
  }

  onToggle6(): Observable <any>{
    return this.subject6.asObservable();
  }

  
  uploadImage(vals:any):Observable<any>{
    let data = vals;
    return this.http.post('https://api.cloudinary.com/v1_1/duooheafl/image/upload',data);
  }

}