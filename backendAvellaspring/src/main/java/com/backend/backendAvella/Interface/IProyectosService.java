/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Interface;


import com.backend.backendAvella.Entity.Proyectos;
import java.util.List;


public interface IProyectosService {
    
    public List<Proyectos> obtenerProyecto();

    public Proyectos crearProyecto(Proyectos proyectos);

    public void borrarProyecto(Long id);

    public Proyectos obtenerProyecto(Long id);

    public void modificarProyecto(Proyectos proyectos);
    
    public List<Proyectos> obtenerProyectosByUsuario(Long id);
}

