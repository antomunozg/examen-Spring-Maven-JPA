package com.prueba.examen.controllers;


import com.prueba.examen.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;


}
