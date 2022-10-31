/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

public class Redes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String linked;
    
    @NotNull
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String git;

    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String face;

    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String insta;
    
    @NotNull
    private Long usuario_id;
    

    public Redes() {
    }

    public Redes(Long usuario_id, String linked, String git, String face, String insta) {
        
        this.linked = linked;
        this.git    = git;
        this.face   = face;
        this.insta  = insta;
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Redes{" + "id=" + id + 
                ", linked=" + linked  + 
                ", Git=" + git + 
                ", Facebook=" + face + 
                ", usuario_id=" + usuario_id + 
                ", Instagram=" + insta + '}';
    }

}
