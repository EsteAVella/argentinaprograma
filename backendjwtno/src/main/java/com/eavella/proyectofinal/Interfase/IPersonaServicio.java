

package com.eavella.proyectofinal.Interfase;

import com.eavella.proyectofinal.Entidad.Persona;
import java.util.List;

public interface IPersonaServicio {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
        
    public void deletePersona(Long id);
   
    public Persona buscarPersona(Long id);
    
}

