package com.prueba.examen.controllers;


import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;



    @PostMapping("/registrar-en-examen/{examenId}")
    public ResponseEntity<Pregunta> registrarPreguntaEnExamen(
            @PathVariable Long examenId,
            @RequestBody Pregunta pregunta
    ) {
        Pregunta nuevaPregunta = preguntaService.registrarPreguntaEnExamen(examenId, pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPregunta);
    }

    //ACTUALIZAR
    //ELIMINAR
}
