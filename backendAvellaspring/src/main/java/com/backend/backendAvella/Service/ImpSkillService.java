/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.backendAvella.Service;

import com.backend.backendAvella.Entity.Skill;
import com.backend.backendAvella.Interface.ISkillsService;
import com.backend.backendAvella.Repository.ISkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 54113
 */
@Service
public class ImpSkillService implements ISkillsService {

    @Autowired
    ISkillRepository iskillRepository;

    @Override
    public List<Skill> obtenerSkill() {
        return iskillRepository.findAll();
    }

    @Override
    public Skill crearSkill(Skill skill) {
        return iskillRepository.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
        iskillRepository.deleteById(id);
    }

    @Override
    public Skill obtenerSkill(Long id) {
        return iskillRepository.findById(id).orElse(null);
    }

    @Override
    public void modificarSkill(Skill skill) {
       iskillRepository.save(skill);
    }
    @Override
    public List<Skill> obtenerSkillByUsuario(Long id) {
       return iskillRepository.findSkillByUsuario(id);
    }
}
