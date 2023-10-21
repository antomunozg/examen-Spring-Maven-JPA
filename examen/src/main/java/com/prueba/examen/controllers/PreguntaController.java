package com.prueba.examen.controllers;


import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping("/crear")
    public ResponseEntity<Pregunta> crearPregunta(@RequestBody Pregunta pregunta) {
        Pregunta nuevaPregunta = preguntaService.crearPregunta(pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPregunta);
    }

    @PostMapping("/crearPreguntaConOpcionesYAsociarRespuestas")
    public ResponseEntity<Pregunta> crearPreguntaConOpcionesYAsociarRespuestas(
            @RequestBody Pregunta pregunta,
            @RequestBody List<Opcion> opciones,
            @RequestBody List<Respuesta> respuestas
    ) {
        Pregunta nuevaPregunta = preguntaService.crearPreguntaConOpcionesYAsociarRespuestas(pregunta, opciones, respuestas);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPregunta);
    }
}
