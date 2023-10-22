package com.prueba.examen.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PreguntaDTO {


    private Long id;

    private String enunciado;

    private int puntaje;

    private ExamenDTO examen;

    @Transient
    private List<OpcionDTO> opciones;

    public PreguntaDTO(String enunciado, int puntaje) {
        this.enunciado = enunciado;
        this.puntaje = puntaje;
    }

    public PreguntaDTO(Long id, String enunciado, int puntaje, ExamenDTO examen, List<OpcionDTO> opciones) {
        this.id = id;
        this.enunciado = enunciado;
        this.puntaje = puntaje;
        this.examen = examen;
        this.opciones = opciones;
    }

}

