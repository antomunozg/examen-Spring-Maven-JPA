package com.prueba.examen.repositories;


import com.prueba.examen.dto.OpcionDTO;
import com.prueba.examen.entities.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, Long> {

    @Query("SELECT NEW com.prueba.examen.dto.OpcionDTO(o.texto, o.esCorrecta) FROM Opcion o WHERE o.id = :idOpcion")
    OpcionDTO detalleOpcion(@Param("idOpcion") Long idOpcion);

}
