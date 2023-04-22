
package com.backend.backendAvella.Controller;

import com.backend.backendAvella.Entity.Skill;
import com.backend.backendAvella.Interface.ISkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin( origins = "https://portfolio-avella.web.app" )

public class SkillController {

    @Autowired
    ISkillsService iskillService;

    @GetMapping("/skills")
    public List<Skill> obtenerSkill() {
        return iskillService.obtenerSkill();
    }

    @PostMapping("/skills/create")
    public Skill crearSkill(@RequestBody Skill skill) {
        return iskillService.crearSkill(skill);
    }

    @DeleteMapping("/skills/{id}")
    public void borrarSkill(@PathVariable Long id) {
        iskillService.borrarSkill(id);
    }

    @GetMapping("/skills/{id}")
    public List<Skill> obtenerSkillByUsuario(@PathVariable Long id) {
        return iskillService.obtenerSkillByUsuario(id);
    }

    @PutMapping("/skills/update")
    public void modificarSkill(@RequestBody Skill skill) {
        System.out.println(skill);
        iskillService.modificarSkill(skill);
    }
}
