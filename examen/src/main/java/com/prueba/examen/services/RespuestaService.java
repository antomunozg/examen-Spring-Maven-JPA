package com.prueba.examen.services;

import com.prueba.examen.dto.*;
import com.prueba.examen.entities.Respuesta;
import com.prueba.examen.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private OpcionRepository opcionRepository;

    public List<Respuesta> registrarRespuestaEstudiante(List<Respuesta> respuesta) {
        // Aquí puedes agregar validaciones o lógica adicional antes de guardar la respuesta
        return respuesta.stream().map(r -> respuestaRepository.save(r)).toList();
    }

    public RespuestaDTO recopilarRespuestasDeEstudianteEnExamen(Long estudianteId, Long examenId) {
        List<RespuestaDTO> respuestas =  respuestaRepository.respuestas(estudianteId,examenId);
        ExamenDTO examen = examenRepository.detalleExamen(examenId);
        EstudianteDTO estudiante = estudianteRepository.detalleEstudiante(estudianteId);
        List<PreguntaDTO> preguntas = new ArrayList<>();
        List<OpcionDTO> opciones = new ArrayList<>();
        respuestas.forEach(r -> {
            preguntas.add(preguntaRepository.detallePregunta(r.getPregunta().getId()));
            opciones.add(opcionRepository.detalleOpcion(r.getOpcionSeleccionada().getId()));
        });

        RespuestaDTO respuesta = new RespuestaDTO();
        respuesta.setExamen(examen);
        respuesta.setEstudiante(estudiante);
        respuesta.setOpcionesSeleccionada(opciones);
        respuesta.setPreguntas(preguntas);

        return respuesta;
    }

    public int calcularPuntajeTotal(RespuestaDTO respuestas) {
        int puntajeTotal = 0;

            // Verifica si la opción seleccionada es correcta
        for(OpcionDTO opcion : respuestas.getOpcionesSeleccionada()){
            if (opcion != null && opcion.isEsCorrecta()) {
                puntajeTotal = respuestas.getPreguntas().stream().mapToInt(PreguntaDTO::getPuntaje).sum();
            }
        }


        return puntajeTotal;
    }
}
