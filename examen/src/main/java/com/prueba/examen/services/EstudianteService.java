package com.prueba.examen.services;


import com.prueba.examen.entities.Estudiante;
import com.prueba.examen.entities.Examen;
import com.prueba.examen.repositories.EstudianteRepository;
import com.prueba.examen.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ExamenRepository examenRepository;


    public Estudiante crearEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    public void asignarExamenAEstudiante(Long estudianteId, Long examenId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElse(null);

        Examen examen = examenRepository.findById(examenId)
                .orElse(null);

        if (estudiante != null && examen != null) {
            ZoneId zonaHorariaEstudiante = ZoneId.of(estudiante.getZonaHoraria());

            ZonedDateTime fechaPresentacionBogota = examen.getFechaPresentacion()
                    .atStartOfDay()  // Convierte la fecha a un objeto ZonedDateTime con la hora a las 00:00
                    .atZone(ZoneId.of("America/Bogota"));

            ZonedDateTime fechaPresentacionEstudiante = fechaPresentacionBogota.withZoneSameInstant(zonaHorariaEstudiante);

            agregarExamenAsignado(estudiante, examen, fechaPresentacionEstudiante.toLocalDate());
            estudianteRepository.save(estudiante);
        }
    }

    public Estudiante asociarEstudianteAExamen(Long estudianteId, Long examenId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId).orElse(null);
        Examen examen = examenRepository.findById(examenId).orElse(null);

        if (estudiante != null && examen != null) {
            // Asociar el estudiante al examen
            estudiante.getExamenesAsignados().add(examen);
            examen.getEstudiantesAsignados().add(estudiante);
            // Actualizar tanto el estudiante como el examen en la base de datos
            estudianteRepository.save(estudiante);
            examenRepository.save(examen);
            return estudiante;
        } else {
            // Manejo de errores o mensajes de error en caso de que el estudiante o el examen no se encuentren
            return null;
        }
    }

    public void agregarExamenAsignado(Estudiante estudiante, Examen examen, LocalDate fechaPresentacionEstudiante) {

        // Puedes establecer la fecha de presentación del examen aquí si es relevante para tu aplicación
        examen.setFechaPresentacion(fechaPresentacionEstudiante);
        // Agregar el examen a la lista de exámenes asignados al estudiante
        estudiante.getExamenesAsignados().add(examen);

        // Realizar alguna lógica adicional si es necesario


    }




}
