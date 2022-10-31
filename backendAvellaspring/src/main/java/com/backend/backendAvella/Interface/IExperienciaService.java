package com.backend.backendAvella.Interface;


import com.backend.backendAvella.Entity.Experiencia;
import java.util.List;


public interface IExperienciaService {
    
    public List<Experiencia> obtenerExperiencia();

    public Experiencia crearExperiencia(Experiencia experiencia);

    public void borrarExperiencia(Long id);

    public Experiencia obtenerExperiencia(Long id);

    public void modificarExperiencia(Experiencia experiencia);
    
    public List<Experiencia> obtenerExperienciaByUsuario(Long id);
}
