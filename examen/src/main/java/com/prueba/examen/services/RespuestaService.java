package com.prueba.examen.services;

import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    public Respuesta registrarRespuestaEstudiante(Respuesta respuesta) {
        // Aquí puedes agregar validaciones o lógica adicional antes de guardar la respuesta
        return respuestaRepository.save(respuesta);
    }

    public List<Respuesta> recopilarRespuestasDeEstudianteEnExamen(Long estudianteId, Long examenId) {
        return respuestaRepository.findByEstudianteIdAndExamenId(estudianteId, examenId);
    }

    public int calcularPuntajeTotal(List<Respuesta> respuestas) {
        int puntajeTotal = 0;
        for (Respuesta respuesta : respuestas) {
            // Verifica si la opción seleccionada es correcta
            if (respuesta.getOpcionSeleccionada() != null && respuesta.getOpcionSeleccionada().isEsCorrecta()) {
                puntajeTotal += respuesta.getPregunta().getPuntaje(); // Incrementa el puntaje si la respuesta es correcta
            }
        }
        return puntajeTotal;
    }
}
