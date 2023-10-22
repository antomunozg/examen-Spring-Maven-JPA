package com.prueba.examen.services;

import com.prueba.examen.entities.ExamenEntity;
import com.prueba.examen.entities.PreguntaEntity;
import com.prueba.examen.repositories.ExamenRepository;
import com.prueba.examen.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private ExamenRepository examenRepository;


    public PreguntaEntity crearPregunta(PreguntaEntity pregunta) {
        return preguntaRepository.save(pregunta);
    }

    public PreguntaEntity obtenerPreguntaPorId(Long preguntaId) {
        return preguntaRepository.findById(preguntaId).orElse(null);
    }

    public PreguntaEntity registrarPreguntaEnExamen(Long examenId, PreguntaEntity pregunta) {
        ExamenEntity examen = examenRepository.findById(examenId).orElse(null);
        if (examen != null) {
            pregunta.setExamen(examen);
            return preguntaRepository.save(pregunta);
        } else {
            // Lógica de manejo de errores si el examen no se encuentra
            return null;
        }
    }
}
