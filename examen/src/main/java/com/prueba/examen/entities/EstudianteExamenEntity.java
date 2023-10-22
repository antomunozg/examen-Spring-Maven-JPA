package com.prueba.examen.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name = "estudiante_examen")
public class EstudianteExamenEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudianteExamen;

    @ManyToOne
    @JoinColumn(name="idEstudiante")
    private EstudianteEntity estudiante;

    @ManyToOne
    @JoinColumn(name="idExamen")
    private ExamenEntity examen;


    private LocalDateTime fechaPresentacion;

}
