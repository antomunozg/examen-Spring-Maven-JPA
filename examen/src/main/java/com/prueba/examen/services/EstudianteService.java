package com.prueba.examen.services;


import com.prueba.examen.dto.EstudianteDTO;
import com.prueba.examen.dto.EstudianteExamenDTO;
import com.prueba.examen.dto.ExamenDTO;
import com.prueba.examen.dto.RespuestaHttpDTO;
import com.prueba.examen.entities.EstudianteEntity;
import com.prueba.examen.entities.EstudianteExamenEntity;
import com.prueba.examen.entities.ExamenEntity;
import com.prueba.examen.repositories.EstudianteExamenRepository;
import com.prueba.examen.repositories.EstudianteRepository;
import com.prueba.examen.repositories.ExamenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private EstudianteExamenRepository estudianteExamenRepository;

    @Autowired
    private ModelMapper modelMapper;


    public EstudianteEntity crearEstudiante(EstudianteDTO estudiante) {
        estudiante.setZonaHoraria(ZoneId.systemDefault().getId());
        return estudianteRepository.save(modelMapper.map(estudiante, EstudianteEntity.class));
    }


    public RespuestaHttpDTO asociarEstudianteAExamen(Long estudianteId, Long examenId) {
        EstudianteDTO estudiante = estudianteRepository.idEstudiante(estudianteId);
        ExamenDTO examen = examenRepository.examen(examenId);

        if (estudiante != null && examen != null) {
            EstudianteExamenDTO estudianteExamenDTO =  new EstudianteExamenDTO();
            estudianteExamenDTO.setEstudiante(estudiante);
            estudianteExamenDTO.setExamen(examen);
            OffsetDateTime offsetDateTimeBogota = examen.getFechaPresentacion().atZone(ZoneId.of("America/Bogota")).toOffsetDateTime();
            OffsetDateTime offsetDateTimeEstudiante = offsetDateTimeBogota.withOffsetSameInstant(ZoneId.of(estudiante.getZonaHoraria()).getRules().getOffset(offsetDateTimeBogota.toInstant()));
            estudianteExamenDTO.setFechaPresentacion(offsetDateTimeEstudiante.toLocalDateTime());

            RespuestaHttpDTO respuesta = new RespuestaHttpDTO();
            respuesta.setMensaje("Se realizo la asociacion correctamente");
            respuesta.setStatus(HttpStatus.OK);
            respuesta.setContenido(estudianteExamenRepository.save(modelMapper.map(estudianteExamenDTO, EstudianteExamenEntity.class)));
            return respuesta;
        } else {
            return null;
        }
    }
}
