
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Experiencia;
import com.backend.backendAvella.Interface.IExperienciaService;
import com.backend.backendAvella.Repository.IExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpExperienciaService implements IExperienciaService {

    @Autowired
    public IExperienciaRepository iexperienciaRepository;

    @Override
    public List<Experiencia> obtenerExperiencia() {
        return iexperienciaRepository.findAll();
    }

    @Override
    public Experiencia crearExperiencia(Experiencia experiencia) {
        return iexperienciaRepository.save(experiencia);
    }

    @Override
    public void borrarExperiencia(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia obtenerExperiencia(Long id) {
        return iexperienciaRepository.findById(id).orElse(null);
    }

    @Override
    public void modificarExperiencia(Experiencia experiencia) {
        iexperienciaRepository.save(experiencia);
    }
        
    @Override
    public List<Experiencia> obtenerExperienciaByUsuario(Long id) {
       return iexperienciaRepository.findExperienciaByUsuario(id);
    }
    

}
