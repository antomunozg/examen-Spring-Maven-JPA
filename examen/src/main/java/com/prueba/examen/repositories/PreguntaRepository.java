package com.prueba.examen.repositories;

import com.prueba.examen.dto.PreguntaDTO;
import com.prueba.examen.entities.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    @Query("SELECT new com.prueba.examen.dto.PreguntaDTO(p.enunciado, p.puntaje) FROM Pregunta p WHERE p.id = :idPregunta" )
    PreguntaDTO detallePregunta(@Param("idPregunta") Long idPregunta);

}
