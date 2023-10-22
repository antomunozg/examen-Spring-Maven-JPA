package com.prueba.examen.repositories;

import com.prueba.examen.dto.RespuestaDTO;
import com.prueba.examen.entities.RespuestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<RespuestaEntity, Long> {

    @Query("SELECT new com.prueba.examen.dto.RespuestaDTO(r.pregunta.id, r.opcionSeleccionada.id) FROM RespuestaEntity r WHERE  r.examen.id = :idExamen and r.estudiante.id = :idEstudiante")
    List<RespuestaDTO> respuestas(@Param("idEstudiante") Long estudianteId, @Param("idExamen") Long examenId);
}
