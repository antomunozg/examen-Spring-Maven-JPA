package com.prueba.examen.controllers;


import com.prueba.examen.dto.RespuestaDTO;
import com.prueba.examen.entities.RespuestaEntity;
import com.prueba.examen.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;


    @PostMapping("/registrar")
    public ResponseEntity<List<RespuestaEntity>> registrarRespuestaEstudiante(@RequestBody List<RespuestaEntity> respuesta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.registrarRespuestaEstudiante(respuesta));
    }

    @GetMapping("/recopilar/{estudianteId}/{examenId}")
    public ResponseEntity<Map<String, Object>> recopilarRespuestasYCalcularPuntaje(
            @PathVariable Long estudianteId,
            @PathVariable Long examenId
    ) {
        RespuestaDTO respuestas = respuestaService.recopilarRespuestasDeEstudianteEnExamen(estudianteId, examenId);
        int puntajeTotal = respuestaService.calcularPuntajeTotal(respuestas);

        Map<String, Object> response = new HashMap<>();
        response.put("respuestas", respuestas);
        response.put("puntajeTotal", puntajeTotal);

        return ResponseEntity.ok(response);
    }
}
