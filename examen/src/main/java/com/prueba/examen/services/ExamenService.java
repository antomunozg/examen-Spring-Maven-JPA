package com.prueba.examen.services;

import com.prueba.examen.dto.ExamenDTO;
import com.prueba.examen.dto.PreguntaDTO;
import com.prueba.examen.entities.ExamenEntity;
import com.prueba.examen.entities.OpcionEntity;
import com.prueba.examen.entities.PreguntaEntity;
import com.prueba.examen.repositories.ExamenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public ExamenEntity crearExamen(ExamenDTO examen) {
        ExamenEntity ex = examenRepository.save(modelMapper.map(examen, ExamenEntity.class));
        examen.getPreguntas().forEach(p -> {
            ExamenDTO examenDTO = new ExamenDTO();
            examenDTO.setId(ex.getId());
            p.setExamen(examenDTO);
            Long idPregunta = preguntaService.crearPregunta(modelMapper.map(p, PreguntaEntity.class)).getId();
            p.getOpciones().forEach(o -> {
                PreguntaDTO pregunta = new PreguntaDTO();
                pregunta.setId(idPregunta);
                o.setPregunta(pregunta);
                opcionService.crearOpcion(modelMapper.map(o, OpcionEntity.class));
            });
        });
        return ex;
    }
}
