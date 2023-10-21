package com.prueba.examen.services;

import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private OpcionService opcionService;

    @Autowired
    private RespuestaService respuestaService;

    public Pregunta crearPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta crearPreguntaConOpcionesYAsociarRespuestas(Pregunta pregunta, List<Opcion> opciones, List<Respuesta> respuestas) {
        Pregunta nuevaPregunta = preguntaRepository.save(pregunta);

        for (Opcion opcion : opciones) {
            opcion.setPregunta(nuevaPregunta);
            opcionService.crearOpcion(opcion);
        }

        for (Respuesta respuesta : respuestas) {
            respuesta.setPregunta(nuevaPregunta);
            respuestaService.crearRespuesta(respuesta);
        }

        return nuevaPregunta;
    }
}
