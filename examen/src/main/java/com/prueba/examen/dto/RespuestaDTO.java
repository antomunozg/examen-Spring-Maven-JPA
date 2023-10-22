package com.prueba.examen.dto;

import com.prueba.examen.entities.Estudiante;
import com.prueba.examen.entities.Examen;
import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class RespuestaDTO {

    private Long id;

    private PreguntaDTO pregunta;


    private ExamenDTO examen;

    private EstudianteDTO estudiante;

    private OpcionDTO opcionSeleccionada;

    @Transient
    private List<OpcionDTO> opcionesSeleccionada;

    @Transient
    private  List<PreguntaDTO> preguntas;

    public RespuestaDTO(Long idPregunta, Long idOpcionSeleccionada) {
        PreguntaDTO pregunta = new PreguntaDTO();
        pregunta.setId(idPregunta);
        OpcionDTO opcion = new OpcionDTO();
        opcion.setId(idOpcionSeleccionada);
        this.pregunta = pregunta;
        this.opcionSeleccionada = opcion;
    }


    public RespuestaDTO(PreguntaDTO pregunta, ExamenDTO examen, EstudianteDTO estudiante, OpcionDTO opcionSeleccionada) {
        this.pregunta = pregunta;
        this.examen = examen;
        this.estudiante = estudiante;
        this.opcionSeleccionada = opcionSeleccionada;
    }

}
