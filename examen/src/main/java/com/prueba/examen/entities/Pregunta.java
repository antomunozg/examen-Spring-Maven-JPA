package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pregunta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private int puntaje;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "examen_id")
    private Examen examen;

    @JsonIgnore
    @OneToMany(mappedBy = "pregunta")
    private List<Opcion> opciones;

    public Pregunta() {

    }

    public Pregunta(Long id, String enunciado, int puntaje, Examen examen, List<Opcion> opciones) {
        this.id = id;
        this.enunciado = enunciado;
        this.puntaje = puntaje;
        this.examen = examen;
        this.opciones = opciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
}
