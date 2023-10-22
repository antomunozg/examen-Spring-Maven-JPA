package com.prueba.examen.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "examen")
public class ExamenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDateTime fechaPresentacion;
    private int puntajeTotal;

    public ExamenEntity(Long id, String nombre, LocalDateTime fechaPresentacion, int puntajeTotal) {
        this.id = id;
        this.nombre = nombre;
        this.fechaPresentacion = fechaPresentacion;
        this.puntajeTotal = puntajeTotal;
    }
}
