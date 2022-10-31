
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Proyectos;
import com.backend.backendAvella.Interface.IProyectosService;
import com.backend.backendAvella.Repository.IProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpProyectosService implements IProyectosService {
    
    @Autowired
    public IProyectosRepository iproyectosRepository;
   
    @Override
    public List<Proyectos> obtenerProyecto() {
        return iproyectosRepository.findAll();
    }

    @Override
    public Proyectos crearProyecto(Proyectos proyectos) {
        return iproyectosRepository.save(proyectos);
    }

    @Override
    public void borrarProyecto(Long id) {
       iproyectosRepository.deleteById(id);
    }

    @Override
    public Proyectos obtenerProyecto(Long id) {
        return iproyectosRepository.findById(id).orElse(null);
    }

    @Override
    public void modificarProyecto(Proyectos proyectos) {
         iproyectosRepository.save(proyectos);
    }

    @Override
    public List<Proyectos> obtenerProyectosByUsuario(Long id) {
        return iproyectosRepository.findProyectosByUsuario(id);
    }
}
