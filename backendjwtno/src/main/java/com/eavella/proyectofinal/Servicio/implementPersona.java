/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eavella.proyectofinal.Servicio;

import com.eavella.proyectofinal.Entidad.Persona;
import com.eavella.proyectofinal.Interfase.IPersonaServicio;
import com.eavella.proyectofinal.Repositorio.InterfazPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class implementPersona implements IPersonaServicio {
    @Autowired InterfazPersona interfazPersona;
    
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = interfazPersona.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        interfazPersona.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        interfazPersona.deleteById(id);
    }

    @Override
    public Persona buscarPersona(Long id) {
        Persona persona = interfazPersona.findById(id).orElse(null);
        return persona;
    }
    
}
