
package com.eavella.proyectofinal.Security.Repository;

import com.eavella.proyectofinal.Security.Entidad.Rol;
import com.eavella.proyectofinal.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface iRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
            
    }
