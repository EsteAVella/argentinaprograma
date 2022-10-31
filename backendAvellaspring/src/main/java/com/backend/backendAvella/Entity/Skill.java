
package com.backend.backendAvella.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity

public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    
    @NotNull
    private int porcentaje;

    @NotNull
    private Long usuario_id;

    public Skill() {
    }

    public Skill(Long usuario_id, String nombre, int porcentaje, String persona) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Skills{" + "id=" + id + 
                ", nombre=" + nombre + 
                ", porcentaje="+ porcentaje + 
                ", usuario_id=" + usuario_id + '}';
    }
}
