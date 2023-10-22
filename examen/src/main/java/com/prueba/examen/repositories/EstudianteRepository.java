package com.prueba.examen.repositories;


import com.prueba.examen.dto.EstudianteDTO;
import com.prueba.examen.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    @Query("SELECT NEW com.prueba.examen.dto.EstudianteDTO(e.id, e.zonaHoraria) FROM EstudianteEntity e  WHERE e.id = :idEstudiante")
   EstudianteDTO idEstudiante(@Param("idEstudiante") Long idEstudiante);

    @Query("SELECT NEW com.prueba.examen.dto.EstudianteDTO(e.id, e.nombre, e.edad, e.ciudad, e.zonaHoraria) FROM EstudianteEntity e  WHERE e.id = :idEstudiante")
    EstudianteDTO detalleEstudiante(@Param("idEstudiante") Long idEstudiante);

}
