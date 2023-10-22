package com.prueba.examen.services;

import com.prueba.examen.entities.Examen;
import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.repositories.ExamenRepository;
import com.prueba.examen.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private ExamenRepository examenRepository;


    public Pregunta crearPregunta(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public Pregunta obtenerPreguntaPorId(Long preguntaId) {
        return preguntaRepository.findById(preguntaId).orElse(null);
    }

    public Pregunta registrarPreguntaEnExamen(Long examenId, Pregunta pregunta) {
        Examen examen = examenRepository.findById(examenId).orElse(null);
        if (examen != null) {
            pregunta.setExamen(examen);
            return preguntaRepository.save(pregunta);
        } else {
            // Lógica de manejo de errores si el examen no se encuentra
            return null;
        }
    }
}
