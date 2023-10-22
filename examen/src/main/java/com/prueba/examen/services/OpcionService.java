package com.prueba.examen.services;

import com.prueba.examen.entities.OpcionEntity;
import com.prueba.examen.repositories.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    public OpcionEntity crearOpcion(OpcionEntity opcion) {
        return opcionRepository.save(opcion);
    }

    public OpcionEntity actualizarOpcion(OpcionEntity opcion) {
        return opcionRepository.save(opcion);
    }
}
