import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { persona } from "../config/persona.model";

@Injectable({
    providedIn: 'root'
})

export class PersonaService {
     url = 'https://avellaestebanback.onrender.com/personas/';

    constructor( private http : HttpClient ) { }

    public getPersona(): Observable<persona> {

        return this.http.get<persona>(this.url+'traer/perfil');
    }

}
