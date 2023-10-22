package com.prueba.examen.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class ExamenDTO {


    private Long id;
    private String nombre;
    private LocalDateTime fechaPresentacion;
    private int puntajeTotal;

    @Transient
    private List<EstudianteDTO> estudiantesAsignados;

    @Transient
    private List<PreguntaDTO> preguntas;

    @Transient

    private List<RespuestaDTO> respuestas;

    public ExamenDTO(Long id, LocalDateTime fechaPresentacion) {
        this.id = id;
        this.fechaPresentacion = fechaPresentacion;
    }

    public ExamenDTO(Long id, String nombre, LocalDateTime fechaPresentacion, int puntajeTotal, List<EstudianteDTO> estudiantesAsignados, List<PreguntaDTO> preguntas, List<RespuestaDTO> respuestas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPresentacion = fechaPresentacion;
        this.puntajeTotal = puntajeTotal;
        this.estudiantesAsignados = estudiantesAsignados;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
    }

    public ExamenDTO(Long id, String nombre, LocalDateTime fechaPresentacion, int puntajeTotal) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPresentacion = fechaPresentacion;
        this.puntajeTotal = puntajeTotal;
    }

}
