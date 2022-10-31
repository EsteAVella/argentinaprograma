/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Repository;

import com.backend.backendAvella.Entity.Redes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IRedesRepository extends JpaRepository<Redes, Long> {
    
    @Query(value="SELECT * FROM redes WHERE redes.usuario_id = :usuario_id",nativeQuery=true)
    
    public Redes findRedesByUsuario(Long usuario_id);

}
