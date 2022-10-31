package com.backend.backendAvella.Interface;

import com.backend.backendAvella.Entity.Educacion;
import java.util.List;


public interface IEducacionService {
    
    public List<Educacion> obtenerEducacion();

    public Educacion crearEducacion(Educacion educacion);

    public void borrarEducacion(Long id);

    public Educacion obtenerEducacion(Long id);

    public void modificarEducacion(Educacion educacion);
   
    public List<Educacion> obtenerEducacionByUsuario(Long id);
}
