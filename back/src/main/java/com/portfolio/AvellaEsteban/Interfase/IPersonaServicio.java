/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.AvellaEsteban.Interfase;

import com.portfolio.AvellaEsteban.Entidad.Persona;
import java.util.List;


public interface IPersonaServicio {
   
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
        
    public void deletePersona(Long id);
   
    public Persona buscarPersona(Long id);
    
}
