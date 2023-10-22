package com.prueba.examen.repositories;

import com.prueba.examen.entities.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

    List<Respuesta> findByEstudianteIdAndExamenId(Long estudianteId, Long examenId);
}
