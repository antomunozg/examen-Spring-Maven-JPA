package com.prueba.examen.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "opcion_id")
    private Opcion opcionSeleccionada;

    public Respuesta(Pregunta pregunta, Examen examen, Estudiante estudiante, Opcion opcionSeleccionada) {
        this.pregunta = pregunta;
        this.examen = examen;
        this.estudiante = estudiante;
        this.opcionSeleccionada = opcionSeleccionada;
    }

}
