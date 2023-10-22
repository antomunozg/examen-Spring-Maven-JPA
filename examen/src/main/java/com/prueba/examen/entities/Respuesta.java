package com.prueba.examen.entities;

import jakarta.persistence.*;

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

    public Respuesta() {
    }

    public Respuesta(Pregunta pregunta, Examen examen, Estudiante estudiante, Opcion opcionSeleccionada) {
        this.pregunta = pregunta;
        this.examen = examen;
        this.estudiante = estudiante;
        this.opcionSeleccionada = opcionSeleccionada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Opcion getOpcionSeleccionada() {
        return opcionSeleccionada;
    }

    public void setOpcionSeleccionada(Opcion opcionSeleccionada) {
        this.opcionSeleccionada = opcionSeleccionada;
    }
}
