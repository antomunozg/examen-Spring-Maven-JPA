package com.prueba.examen.controllerTest;

import com.prueba.examen.ExamenApplication;
import com.prueba.examen.controllers.PreguntaController;
import com.prueba.examen.entities.PreguntaEntity;
import com.prueba.examen.services.PreguntaService;
import org.junit.jupiter.api.Assertions;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = ExamenApplication.class)
public class PreguntaControllerTest {

    @Mock
    private PreguntaService preguntaService;

    @InjectMocks
    private PreguntaController preguntaController;

    @BeforeEach
    public void setUp() {
        // Inicializar el controlador y servicios antes de cada prueba
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegistrarPreguntaEnExamen() throws Exception {
        // Datos de ejemplo
        Long examenId = 1L;
        PreguntaEntity nuevaPregunta = new PreguntaEntity();

        // Mock para simular el comportamiento del servicio de pregunta
        Mockito.when(preguntaService.registrarPreguntaEnExamen(examenId, nuevaPregunta)).thenReturn(nuevaPregunta);

        // Ejecutar el método del controlador
        ResponseEntity<PreguntaEntity> respuesta = preguntaController.registrarPreguntaEnExamen(examenId, nuevaPregunta);

        // Verificar que el método devuelve una respuesta HTTP 201 (CREATED)
        Assertions.assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // Verificar que el servicio de pregunta fue llamado para registrar la pregunta en el examen
        Mockito.verify(preguntaService, Mockito.times(1)).registrarPreguntaEnExamen(examenId, nuevaPregunta);
    }


}
