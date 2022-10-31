/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Repository;

import com.backend.backendAvella.Entity.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface ISkillRepository extends JpaRepository<Skill, Long> {

   @Query(value="SELECT * FROM skill WHERE skill.usuario_id = :usuario_id",nativeQuery=true)
   public List<Skill> findSkillByUsuario(Long usuario_id);
}
