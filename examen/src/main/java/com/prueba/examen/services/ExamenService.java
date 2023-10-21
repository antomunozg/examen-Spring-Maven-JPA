package com.prueba.examen.services;

import com.prueba.examen.entities.Examen;
import com.prueba.examen.repositories.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenService {


    @Autowired
    private ExamenRepository examenRepository;

    public Examen crearExamen(Examen examen) {
        return examenRepository.save(examen);
    }
}
