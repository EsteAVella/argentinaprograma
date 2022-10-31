
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Educacion;
import com.backend.backendAvella.Interface.IEducacionService;
import com.backend.backendAvella.Repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpEducacionService implements IEducacionService {

    @Autowired
    public IEducacionRepository repository;

    @Override
    public List<Educacion> obtenerEducacion() {
        return repository.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion educacion) {
        return repository.save(educacion);
    }

    @Override
    public void borrarEducacion(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Educacion obtenerEducacion(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void modificarEducacion(Educacion educacion) {
        repository.save(educacion);
    }

    @Override
    public List<Educacion> obtenerEducacionByUsuario(Long id) {
        return repository.findEducacionByUsuario(id);
    }

}
