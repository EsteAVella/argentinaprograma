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
public class Educacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String school;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String title;
    
    private int score;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaI;
        
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaF;
    
    
    @NotNull
    private Long usuario_id;
    
    public Educacion() {
    }

    public Educacion(Long usuario_id, String school, Date fechaI, Date fechaF, String title, int score, String img) {
        this.school = school;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.title = title;
        this.score = score;
        
    }

    @Override
    public String toString() {    
    return "Educacion{"+ "id=" + id + 
                ", school=" + school +
                ", usuario_id=" + usuario_id + 
                ", fecha inicio=" + fechaI +
                ", fecha final=" + fechaF +
                ", title=" + title + 
                ", score=" + score + 
                '}';
    }
}



