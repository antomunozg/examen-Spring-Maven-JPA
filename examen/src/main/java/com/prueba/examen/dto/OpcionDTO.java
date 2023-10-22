package com.prueba.examen.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prueba.examen.entities.Pregunta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class OpcionDTO {

    private Long id;
    private String texto;
    private boolean esCorrecta;
    private PreguntaDTO pregunta;
    public OpcionDTO(String texto, boolean esCorrecta) {
        this.texto = texto;
        this.esCorrecta = esCorrecta;

    }


    public OpcionDTO(Long id, String texto, boolean esCorrecta, PreguntaDTO pregunta) {
        this.id = id;
        this.texto = texto;
        this.esCorrecta = esCorrecta;
        this.pregunta = pregunta;
    }

}
