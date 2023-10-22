package com.prueba.examen.controllers;


import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.services.OpcionService;
import com.prueba.examen.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opciones")
public class OpcionController {

    @Autowired
    private OpcionService opcionService;

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping("/crear")
    public ResponseEntity<Opcion> crearOpcion(@RequestBody Opcion opcion) {
        Opcion nuevaOpcion = opcionService.crearOpcion(opcion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOpcion);
    }

    @PostMapping("/crear-y-asociar-a-pregunta/{preguntaId}")
    public ResponseEntity<Opcion> crearOpcionYAsociarAPregunta(@PathVariable Long preguntaId, @RequestBody Opcion opcion) {
        Opcion nuevaOpcion = opcionService.crearOpcion(opcion);

        // Asociar la opción a la pregunta
        Pregunta pregunta = preguntaService.obtenerPreguntaPorId(preguntaId);
        nuevaOpcion.setPregunta(pregunta);
        opcionService.actualizarOpcion(nuevaOpcion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOpcion);
    }


}
