
package com.backend.backendAvella.Controller;


import com.backend.backendAvella.Entity.Experiencia;
import com.backend.backendAvella.Service.ImpExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaController {

    @Autowired
    public ImpExperienciaService service;

    @GetMapping("/experiencia")
    @ResponseBody
    public List<Experiencia> obtenerExperiencia() {
        return service.obtenerExperiencia();
    }

    @PostMapping("/experiencia/create")
    @ResponseBody
    public Experiencia crearExperiencia(@RequestBody Experiencia experiencia) {
        return service.crearExperiencia(experiencia);
    }

    @DeleteMapping("/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        service.borrarExperiencia(id);
    }

    @GetMapping("/experiencia/{id}")
    public List<Experiencia> obtenerExperienciaByUsuario(@PathVariable Long id) {
        return service.obtenerExperienciaByUsuario(id);
    }

    @PutMapping("/experiencia/update")
    public void modificarExperiencia(@RequestBody Experiencia experiencia) {
        System.out.println(experiencia);
        service.modificarExperiencia(experiencia);
    }
}
