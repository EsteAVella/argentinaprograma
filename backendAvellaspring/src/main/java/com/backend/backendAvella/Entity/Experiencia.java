/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.backendAvella.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
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
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String puesto;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String empresa;
    
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String trabajoActual;

    @Size(min = 1, max = 300, message = "no cumple con la longitud")
    private String descripcion;
    

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inicio;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fin;

    
    private Long usuario_id;


    public Experiencia() {
    }

    public Experiencia(String puesto, String empresa, String img, String trabajoActual, String descripcion, String nombre, Date inicio, Date fin) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.trabajoActual = trabajoActual;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.usuario_id = usuario_id;
    }

    @Override
    public String toString() {
        return "Experiencia{" + "id=" + id + 
                ", descripcion" + descripcion + 
                ", Trabaja actualmente aqui?=" + trabajoActual + 
                ", usuario_id=" + usuario_id + 
                ", Empresa="+ empresa +
                ", Puesto" + puesto + 
                ", Inicio"+ inicio+
                ", Fin:"+ fin +'}';
    }

    
}
