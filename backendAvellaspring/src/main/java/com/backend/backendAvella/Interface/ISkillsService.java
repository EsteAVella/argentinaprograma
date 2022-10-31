/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.backendAvella.Interface;


import com.backend.backendAvella.Entity.Skill;
import java.util.List;

/**
 *
 * @author 54113
 */
public interface ISkillsService {
    public List<Skill> obtenerSkill();

    public Skill crearSkill(Skill skill);

    public void borrarSkill (Long id);

    public Skill obtenerSkill(Long id);

    public void modificarSkill(Skill skill);
    
    public List<Skill> obtenerSkillByUsuario(Long id);
}
