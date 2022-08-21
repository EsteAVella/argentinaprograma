package com.eavella.proyectofinal.Controlador;

import com.eavella.proyectofinal.Entidad.Persona;
import com.eavella.proyectofinal.Interfase.IPersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControladorPersona {

    @Autowired IPersonaServicio impPersona;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return impPersona.getPersona();
    }
    
    @PostMapping("personas/crear")
    public String newPersona(@RequestBody Persona persona ){
        impPersona.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping("personas/borrar/(id)")
    public String borrarPersona(@PathVariable Long id){   
        impPersona.deletePersona(id);
        return "La persona fue eliminada con exito";
    }
    
    @PutMapping("/personas/editar/(id)")
    public Persona editarPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("imagen") String nuevoImagen){
        
        Persona persona = impPersona.buscarPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImagen(nuevoImagen);
        
        impPersona.savePersona(persona);
        return persona;
        
            
    }
    @GetMapping("/persons/traer/perfil")
    public Persona findPersona(){
        return impPersona.buscarPersona((long)0);
    }
}
