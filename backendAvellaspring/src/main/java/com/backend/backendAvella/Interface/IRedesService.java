/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Interface;

import com.backend.backendAvella.Entity.Redes;
import java.util.List;


public interface IRedesService {

    public List<Redes> obtenerRedes();

    public Redes crearRedes(Redes redes);

    public void borrarRedes(Long id);

    public Redes obtenerRedesByUsuario(Long id);

    public void modificarRedes(Redes redes);
    
   
    
}
