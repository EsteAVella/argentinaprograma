/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Repository;

import com.backend.backendAvella.Entity.Proyectos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Long> {
    @Query(value="SELECT * FROM proyectos WHERE proyectos.usuario_id = :usuario_id",nativeQuery=true)
    
    public List<Proyectos> findProyectosByUsuario(Long usuario_id);
}
