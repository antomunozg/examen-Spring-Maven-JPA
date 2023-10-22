package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "pregunta")
public class PreguntaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private int puntaje;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "examen_id")
    private ExamenEntity examen;

    @JsonIgnore
    @OneToMany(mappedBy = "pregunta")
    private List<OpcionEntity> opciones;


    public PreguntaEntity(Long id, String enunciado, int puntaje, ExamenEntity examen, List<OpcionEntity> opciones) {
        this.id = id;
        this.enunciado = enunciado;
        this.puntaje = puntaje;
        this.examen = examen;
        this.opciones = opciones;
    }
}
