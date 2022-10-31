/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Redes;
import com.backend.backendAvella.Interface.IRedesService;
import com.backend.backendAvella.Repository.IRedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImpRedesService implements IRedesService{
    
    @Autowired
    IRedesRepository iredesRepository;
    
    @Override
    public List<Redes> obtenerRedes() {
        List<Redes> redes = iredesRepository.findAll();
        return redes;
    }

    @Override
    public Redes crearRedes(Redes redes) {
       return iredesRepository.save(redes);
    }

    @Override
    public void borrarRedes(Long id) {
       iredesRepository.deleteById(id);
    }

    @Override
    public Redes obtenerRedesByUsuario(Long id) {
       return iredesRepository.findRedesByUsuario(id);
    }

    @Override
    public void modificarRedes(Redes redes) {
         iredesRepository.save(redes);
    }
    
}
