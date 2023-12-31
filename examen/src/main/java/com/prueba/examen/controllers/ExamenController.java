package com.prueba.examen.controllers;


import com.prueba.examen.dto.ExamenDTO;
import com.prueba.examen.entities.ExamenEntity;
import com.prueba.examen.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @Autowired
    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ExamenEntity> crearExamen(@RequestBody ExamenDTO examen) {
        ExamenEntity nuevoExamen = examenService.crearExamen(examen);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoExamen);
    }


}
