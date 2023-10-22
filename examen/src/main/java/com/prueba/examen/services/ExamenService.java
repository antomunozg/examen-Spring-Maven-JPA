package com.prueba.examen.services;

import com.prueba.examen.dto.ExamenDTO;
import com.prueba.examen.dto.OpcionDTO;
import com.prueba.examen.dto.PreguntaDTO;
import com.prueba.examen.entities.Examen;
import com.prueba.examen.entities.Opcion;
import com.prueba.examen.entities.Pregunta;
import com.prueba.examen.repositories.ExamenRepository;
import com.prueba.examen.repositories.PreguntaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ExamenService {


    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OpcionService opcionService;

    @Autowired
    private PreguntaService preguntaService;

    public Examen crearExamen(ExamenDTO examen) {
        Examen ex = examenRepository.save(modelMapper.map(examen, Examen.class));
        examen.getPreguntas().forEach(p -> {
            ExamenDTO examenDTO = new ExamenDTO();
            examenDTO.setId(ex.getId());
            p.setExamen(examenDTO);
            Long idPregunta = preguntaService.crearPregunta(modelMapper.map(p, Pregunta.class)).getId();
            p.getOpciones().forEach(o -> {
                PreguntaDTO pregunta = new PreguntaDTO();
                pregunta.setId(idPregunta);
                o.setPregunta(pregunta);
                opcionService.crearOpcion(modelMapper.map(o, Opcion.class));
            });
        });
        return ex;
    }
}
