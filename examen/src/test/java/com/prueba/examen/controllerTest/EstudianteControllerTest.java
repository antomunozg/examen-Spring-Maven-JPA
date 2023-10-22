package com.prueba.examen.controllerTest;

import com.prueba.examen.ExamenApplication;
import com.prueba.examen.controllers.EstudianteController;
import com.prueba.examen.dto.EstudianteDTO;
import com.prueba.examen.dto.RespuestaHttpDTO;
import com.prueba.examen.entities.EstudianteEntity;
import com.prueba.examen.services.EstudianteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
@SpringBootTest(classes = ExamenApplication.class)
public class EstudianteControllerTest {

    @InjectMocks
    private EstudianteController estudianteController;

    @Mock
    private EstudianteService estudianteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCrearEstudiante() {
        // Mock de entrada
        EstudianteDTO estudianteDTO = new EstudianteDTO();
        EstudianteEntity estudianteCreado = new EstudianteEntity();
        when(estudianteService.crearEstudiante(estudianteDTO)).thenReturn(estudianteCreado);

        // Ejecutar el método del controlador
        ResponseEntity<EstudianteEntity> response = estudianteController.crearEstudiante(estudianteDTO);

        // Verificar que se llamó al servicio y que la respuesta sea la esperada
        verify(estudianteService, times(1)).crearEstudiante(estudianteDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(estudianteCreado, response.getBody());
    }

    @Test
    public void testAsociarEstudianteAExamen() {
        // Mock de entrada
        Long estudianteId = 1L;
        Long examenId = 2L;
        RespuestaHttpDTO respuestaDTO = new RespuestaHttpDTO();
        when(estudianteService.asociarEstudianteAExamen(estudianteId, examenId)).thenReturn(respuestaDTO);

        // Ejecutar el método del controlador
        ResponseEntity<RespuestaHttpDTO> response = estudianteController.asociarEstudianteAExamen(estudianteId, examenId);

        // Verificar que se llamó al servicio y que la respuesta sea la esperada
        verify(estudianteService, times(1)).asociarEstudianteAExamen(estudianteId, examenId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(respuestaDTO, response.getBody());
    }

    @Test
    public void testAsociarEstudianteAExamenNotFound() {
        // Mock de entrada que devuelve null (como si el estudiante no existiera)
        Long estudianteId = 1L;
        Long examenId = 2L;
        when(estudianteService.asociarEstudianteAExamen(estudianteId, examenId)).thenReturn(null);

        // Ejecutar el método del controlador
        ResponseEntity<RespuestaHttpDTO> response = estudianteController.asociarEstudianteAExamen(estudianteId, examenId);

        // Verificar que se llamó al servicio y que la respuesta sea HttpStatus.NOT_FOUND
        verify(estudianteService, times(1)).asociarEstudianteAExamen(estudianteId, examenId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
