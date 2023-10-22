package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prueba.examen.dto.ExamenDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
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


    public Pregunta(Long id, String enunciado, int puntaje, Examen examen, List<Opcion> opciones) {
        this.id = id;
        this.enunciado = enunciado;
        this.puntaje = puntaje;
        this.examen = examen;
        this.opciones = opciones;
    }
}
