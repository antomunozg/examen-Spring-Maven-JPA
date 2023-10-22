package com.prueba.examen.services;

import com.prueba.examen.entities.Opcion;
import com.prueba.examen.repositories.OpcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpcionService {

    @Autowired
    private OpcionRepository opcionRepository;

    public Opcion crearOpcion(Opcion opcion) {
        return opcionRepository.save(opcion);
    }

    public Opcion actualizarOpcion(Opcion opcion) {
        return opcionRepository.save(opcion);
    }
}
