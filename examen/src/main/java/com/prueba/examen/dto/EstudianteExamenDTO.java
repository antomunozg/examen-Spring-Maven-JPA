package com.prueba.examen.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class EstudianteExamenDTO {


    private Long idEstudianteExamen;


    private EstudianteDTO estudiante;


    private ExamenDTO examen;

    private LocalDateTime fechaPresentacion;

    public EstudianteExamenDTO(Long idEstudianteExamen, Long idEstudiante, Long idExamen) {
        this.idEstudianteExamen = idEstudianteExamen;
        EstudianteDTO estudiante = new EstudianteDTO();
        estudiante.setId(idEstudiante);
        ExamenDTO examen = new ExamenDTO();
        examen.setId(idExamen);
        this.estudiante = estudiante;
        this.examen = examen;
    }
}
