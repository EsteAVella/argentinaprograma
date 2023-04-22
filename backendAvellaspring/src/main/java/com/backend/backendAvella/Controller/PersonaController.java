
package com.backend.backendAvella.Controller;

import com.backend.backendAvella.Entity.Persona;
import com.backend.backendAvella.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "https://portfolio-avella.web.app" )
                         
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona (@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "La persona fue creada con exito";
    }
    
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
    
    @PutMapping("/personas/editar/{id}")
    public String editPersona(@RequestBody Persona persona, @PathVariable Long id){
        ipersonaService.savePersona(persona);
        return "La persona fue editada con exito";  
    }
    
    @GetMapping("/personas/traer/{id}")
    public Persona findPersona(@PathVariable Long id){
        return ipersonaService.findPersona(id);
    }
    
    
    @PostMapping("/personas/login")
    public Persona loginUser(@RequestBody Persona userCredential){
       return ipersonaService.loginUser(userCredential);
    }
}

