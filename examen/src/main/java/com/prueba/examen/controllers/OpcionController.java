package com.prueba.examen.controllers;


import com.prueba.examen.entities.OpcionEntity;
import com.prueba.examen.entities.PreguntaEntity;
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



    @PostMapping("/crear-y-asociar-a-pregunta/{preguntaId}")
    public ResponseEntity<OpcionEntity> crearOpcionYAsociarAPregunta(@PathVariable Long preguntaId, @RequestBody OpcionEntity opcion) {
        OpcionEntity nuevaOpcion = opcionService.crearOpcion(opcion);

        // Asociar la opción a la pregunta
        PreguntaEntity pregunta = preguntaService.obtenerPreguntaPorId(preguntaId);
        nuevaOpcion.setPregunta(pregunta);
        opcionService.actualizarOpcion(nuevaOpcion);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOpcion);
    }

    //ACTUALIZAR
    //ELIMINAR

}
