package com.prueba.examen.controllers;


import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;


    @PostMapping("/crear")
    public ResponseEntity<Respuesta> crearRespuesta(@RequestBody Respuesta respuesta) {
        Respuesta nuevaRespuesta = respuestaService.crearRespuesta(respuesta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaRespuesta);
    }
}
