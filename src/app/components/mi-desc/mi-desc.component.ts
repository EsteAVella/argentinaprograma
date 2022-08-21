import { Component, OnInit } from '@angular/core';
import { persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

  @Component({
    selector: 'app-mi-desc',
    templateUrl: './mi-desc.component.html',
    styleUrls: ['./mi-desc.component.css']
  })
  export class MiDescComponent implements OnInit {
  
    persona: persona = new persona( "Esteban","Avella","","");
    
    constructor(public personaService: PersonaService) { }

    ngOnInit(): void {
      this.personaService.getPersona().subscribe(data =>{ this.persona = data });
    }

  }
