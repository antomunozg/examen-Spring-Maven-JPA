package com.prueba.examen.repositories;


import com.prueba.examen.dto.OpcionDTO;
import com.prueba.examen.entities.OpcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionRepository extends JpaRepository<OpcionEntity, Long> {

    @Query("SELECT NEW com.prueba.examen.dto.OpcionDTO(o.texto, o.esCorrecta) FROM OpcionEntity o WHERE o.id = :idOpcion")
    OpcionDTO detalleOpcion(@Param("idOpcion") Long idOpcion);

}
