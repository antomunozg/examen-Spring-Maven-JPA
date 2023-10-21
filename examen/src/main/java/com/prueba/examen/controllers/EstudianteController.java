package com.prueba.examen.controllers;

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
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.crearEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PostMapping("/{estudianteId}/asignar-examen/{examenId}")
    public ResponseEntity<?> asignarExamenAEstudiante(@PathVariable Long estudianteId, @PathVariable Long examenId) {
        estudianteService.asignarExamenAEstudiante(estudianteId, examenId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
