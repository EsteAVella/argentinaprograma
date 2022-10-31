package com.backend.backendAvella.Repository;

import com.backend.backendAvella.Entity.Experiencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    @Query(value="SELECT * FROM experiencia WHERE experiencia.usuario_id = :usuario_id",nativeQuery=true)
    
    public List<Experiencia> findExperienciaByUsuario(Long usuario_id);
    
}
