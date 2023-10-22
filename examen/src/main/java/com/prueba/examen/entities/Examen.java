package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDateTime fechaPresentacion;
    private int puntajeTotal;

    public Examen(Long id, String nombre, LocalDateTime fechaPresentacion, int puntajeTotal) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPresentacion = fechaPresentacion;
        this.puntajeTotal = puntajeTotal;
    }
}
