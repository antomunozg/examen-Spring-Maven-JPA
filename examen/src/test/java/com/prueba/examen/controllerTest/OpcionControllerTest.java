package com.prueba.examen.controllerTest;

import com.prueba.examen.ExamenApplication;
import com.prueba.examen.controllers.OpcionController;
import com.prueba.examen.entities.OpcionEntity;
import com.prueba.examen.entities.PreguntaEntity;
import com.prueba.examen.services.OpcionService;
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
public class OpcionControllerTest {

    @Mock
    private OpcionService opcionService;

    @Mock
    private PreguntaService preguntaService;

    @InjectMocks
    private OpcionController opcionController;

    @BeforeEach
    public void setUp() {
        // Inicializar el controlador y servicios antes de cada prueba
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCrearOpcionYAsociarAPregunta() {
        // Datos de ejemplo
        Long preguntaId = 1L;
        OpcionEntity nuevaOpcion = new OpcionEntity();

        // Mock para simular el comportamiento del servicio de pregunta
        PreguntaEntity pregunta = new PreguntaEntity();
        Mockito.when(preguntaService.obtenerPreguntaPorId(preguntaId)).thenReturn(pregunta);

        // Mock para simular el comportamiento del servicio de opción
        Mockito.when(opcionService.crearOpcion(Mockito.any(OpcionEntity.class))).thenReturn(nuevaOpcion);

        // Ejecutar el método del controlador
        ResponseEntity<OpcionEntity> respuesta = opcionController.crearOpcionYAsociarAPregunta(preguntaId, nuevaOpcion);

        // Verificar que el método devuelve una respuesta HTTP 201 (CREATED)
        Assertions.assertEquals(HttpStatus.CREATED, respuesta.getStatusCode());

        // Verificar que la opción fue asociada a la pregunta
        Assertions.assertEquals(pregunta, nuevaOpcion.getPregunta());

        // Verificar que el servicio de opción fue llamado para crear la opción
        Mockito.verify(opcionService, Mockito.times(1)).crearOpcion(nuevaOpcion);

        // Verificar que el servicio de opción fue llamado para actualizar la opción
        Mockito.verify(opcionService, Mockito.times(1)).actualizarOpcion(nuevaOpcion);
    }
}
