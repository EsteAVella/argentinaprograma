package com.backend.backendAvella.Repository;

import com.backend.backendAvella.Entity.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
    @Query(value="SELECT * FROM educacion WHERE educacion.usuario_id = :usuario_id",nativeQuery=true)
    
    public List<Educacion> findEducacionByUsuario(Long usuario_id);
}
