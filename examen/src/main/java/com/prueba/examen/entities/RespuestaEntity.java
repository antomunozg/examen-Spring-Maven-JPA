package com.prueba.examen.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "respuesta")
public class RespuestaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private PreguntaEntity pregunta;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private ExamenEntity examen;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private EstudianteEntity estudiante;

    @ManyToOne
    @JoinColumn(name = "opcion_id")
    private OpcionEntity opcionSeleccionada;

    public RespuestaEntity(PreguntaEntity pregunta, ExamenEntity examen, EstudianteEntity estudiante, OpcionEntity opcionSeleccionada) {
        this.pregunta = pregunta;
        this.examen = examen;
        this.estudiante = estudiante;
        this.opcionSeleccionada = opcionSeleccionada;
    }

}
