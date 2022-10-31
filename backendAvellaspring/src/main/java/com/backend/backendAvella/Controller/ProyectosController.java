/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.backendAvella.Controller;

import com.backend.backendAvella.Entity.Proyectos;
import com.backend.backendAvella.Service.ImpProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ProyectosController {
    
    @Autowired
    public ImpProyectosService service;
    
    @GetMapping("/proyectos")
    @ResponseBody
    public List<Proyectos> obtenerProyecto() {
        return service.obtenerProyecto();
    }
    
    @PostMapping("/proyectos/create")
    @ResponseBody
    public Proyectos crearProyecto(@RequestBody Proyectos proyectos) {
        return service.crearProyecto(proyectos);
    }
    
    @DeleteMapping("/proyectos/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        service.borrarProyecto(id);
    }
    
    @GetMapping("/proyectos/{id}")
    @ResponseBody
    public List<Proyectos> obtenerProyectosByUsuario(@PathVariable Long id) {
        return service.obtenerProyectosByUsuario(id);
    }
 
    @PutMapping("/proyectos/update")
    public void modificarProyecto(@RequestBody Proyectos proyectos) {
        System.out.println(proyectos);
        service.modificarProyecto(proyectos);
    }
}
