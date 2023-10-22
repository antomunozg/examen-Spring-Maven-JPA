package com.prueba.examen.repositories;

import com.prueba.examen.dto.ExamenDTO;
import com.prueba.examen.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Long> {

    @Query("SELECT NEW com.prueba.examen.dto.ExamenDTO(e.id, e.fechaPresentacion) FROM Examen e WHERE e.id = :idExamen")
    ExamenDTO examen(@Param("idExamen") Long idExamen);

    @Query("SELECT NEW com.prueba.examen.dto.ExamenDTO(e.id, e.nombre, e.fechaPresentacion, e.puntajeTotal ) FROM Examen e WHERE e.id = :idExamen")
    ExamenDTO detalleExamen(@Param("idExamen") Long idExamen);

}
