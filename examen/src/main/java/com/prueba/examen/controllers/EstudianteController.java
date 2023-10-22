package com.prueba.examen.controllers;

import com.prueba.examen.dto.EstudianteDTO;
import com.prueba.examen.dto.RespuestaHttpDTO;
import com.prueba.examen.entities.Estudiante;
import com.prueba.examen.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @PostMapping("/")
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody EstudianteDTO estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PostMapping("/{estudianteId}/asociar-examen/{examenId}")
    public ResponseEntity<RespuestaHttpDTO> asociarEstudianteAExamen(
            @PathVariable Long estudianteId, @PathVariable Long examenId
    ) {
        RespuestaHttpDTO estudiante = estudianteService.asociarEstudianteAExamen(estudianteId, examenId);
        if (estudiante != null) {
            return ResponseEntity.ok().body(estudiante);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
