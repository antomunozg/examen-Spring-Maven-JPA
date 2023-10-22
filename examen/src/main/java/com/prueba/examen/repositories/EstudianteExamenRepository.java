package com.prueba.examen.repositories;

import com.prueba.examen.dto.EstudianteExamenDTO;
import com.prueba.examen.entities.EstudianteExamenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteExamenRepository extends JpaRepository<EstudianteExamenEntity, Long> {

    @Query("SELECT NEW com.prueba.examen.dto.EstudianteExamenDTO(ex.idEstudianteExamen, ex.examen.id, ex.estudiante.id) FROM EstudianteExamenEntity ex where ex.estudiante.id = :idEstudiante")
    List<EstudianteExamenDTO> examenesEstudiante(@Param("idEstudiante") Long idEstudiante);

}
