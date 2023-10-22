package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fechaPresentacion;
    private int puntajeTotal;

    @JsonIgnore
    @ManyToMany(mappedBy = "examenesAsignados")
    private List<Estudiante> estudiantesAsignados;

    @JsonIgnore
    @OneToMany(mappedBy = "examen")
    private List<Pregunta> preguntas;

    @JsonIgnore
    @OneToMany(mappedBy = "examen")
    private List<Respuesta> respuestas;

    public Examen() {
    }

    public Examen(Long id, String nombre, LocalDate fechaPresentacion, int puntajeTotal, List<Estudiante> estudiantesAsignados, List<Pregunta> preguntas, List<Respuesta> respuestas) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPresentacion = fechaPresentacion;
        this.puntajeTotal = puntajeTotal;
        this.estudiantesAsignados = estudiantesAsignados;
        this.preguntas = preguntas;
        this.respuestas = respuestas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(LocalDate fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public List<Estudiante> getEstudiantesAsignados() {
        return estudiantesAsignados;
    }

    public void setEstudiantesAsignados(List<Estudiante> estudiantesAsignados) {
        this.estudiantesAsignados = estudiantesAsignados;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
}
