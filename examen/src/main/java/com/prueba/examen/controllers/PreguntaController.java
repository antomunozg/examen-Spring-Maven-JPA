package com.prueba.examen.controllers;


import com.prueba.examen.entities.PreguntaEntity;
import com.prueba.examen.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;



    @PostMapping("/registrar-en-examen/{examenId}")
    public ResponseEntity<PreguntaEntity> registrarPreguntaEnExamen(
            @PathVariable Long examenId,
            @RequestBody PreguntaEntity pregunta
    ) {
        PreguntaEntity nuevaPregunta = preguntaService.registrarPreguntaEnExamen(examenId, pregunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPregunta);
    }

    //ACTUALIZAR
    //ELIMINAR
}
