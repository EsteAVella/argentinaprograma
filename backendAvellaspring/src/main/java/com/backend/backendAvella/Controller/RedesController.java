
package com.backend.backendAvella.Controller;

import com.backend.backendAvella.Entity.Redes;
import com.backend.backendAvella.Interface.IRedesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RedesController {
    @Autowired
    IRedesService service;

    @GetMapping("/redes")

    public List<Redes> obtenerRedes() {
        return service.obtenerRedes();
    }

    @PostMapping("/redes/create")

    public Redes crearRedes(@RequestBody Redes redes) {
        return service.crearRedes(redes);
    }

    @DeleteMapping("/redes/{id}")
    public void borrarRedes(@PathVariable Long id) {
        service.borrarRedes(id);
    }

    @GetMapping("/redes/{id}")
    public Redes obtenerRedesByUsuario(@PathVariable Long id) {
        return service.obtenerRedesByUsuario(id);
    }

    @PutMapping("/redes/update")
    public void modificarRedes(@RequestBody Redes redes) {
        System.out.println(redes);
        service.modificarRedes(redes);
    }
}
