package com.eavella.proyectofinal.Repositorio;

import com.eavella.proyectofinal.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfazPersona extends JpaRepository<Persona,Long> {
    
    
}
