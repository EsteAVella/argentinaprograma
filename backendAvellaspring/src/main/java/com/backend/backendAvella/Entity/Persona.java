
package com.backend.backendAvella.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Persona {
    
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Educacion> educacion; 
    
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Redes> redes; 
    
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Experiencia> experiencia; 
    
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skill; 
    
    @OneToMany(mappedBy = "usuario_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Proyectos> proyectos; 
     
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;

    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;

    
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String foto;

    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String carrera;

    
    @Size(min = 1, max = 200, message = "no cumple con la longitud")
    private String banner;
    
    
    @Size(min = 1, max = 1000, message = "no cumple con la longitud")
    private String descripcion;
    
    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String email;

    
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String password;

    private boolean isEnabled;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String password, String foto, String carrera, String banner,String descripcion, boolean isEnabled) {
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.foto       = foto;
        this.carrera    = carrera;
        this.email      = email;
        this.banner     = banner;
        this.descripcion = descripcion;
        this.password   = password;
        this.isEnabled  = isEnabled;
        

    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + 
                ", nombre=" + nombre + 
                ", apellido=" + apellido + 
                ", foto=" + foto +
                ", carrera=" + carrera +
                ", banner=" + banner +
                ", descripcion=" + descripcion  +
                ", email=" + email + 
                ", password=" + password + 
                ", isEnabled=" + isEnabled + '}';
    }


}

