package com.prueba.examen.controllerTest;

import com.prueba.examen.ExamenApplication;
import com.prueba.examen.controllers.RespuestaController;
import com.prueba.examen.entities.RespuestaEntity;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.prueba.examen.dto.RespuestaDTO;
import com.prueba.examen.services.RespuestaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ExamenApplication.class)
public class RespuestaControllerTest {

    @Mock
    private RespuestaService respuestaService;

    @InjectMocks
    private RespuestaController respuestaController;

    @BeforeEach
    public void setUp() {
        // Inicializar el controlador y los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrarRespuestaEstudiante() {
        // Mock de datos de entrada
        List<RespuestaEntity> respuestas = new ArrayList<>();
        // Configurar el servicio para devolver datos simulados
        when(respuestaService.registrarRespuestaEstudiante(any(List.class))).thenReturn(respuestas);

        // Llamar al método del controlador
        ResponseEntity<List<RespuestaEntity>> responseEntity = respuestaController.registrarRespuestaEstudiante(respuestas);

        // Verificar que se devuelva el código de estado esperado
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        // Verificar que la respuesta contenga los datos simulados
        assertEquals(respuestas, responseEntity.getBody());
    }

    @Test
    public void testRecopilarRespuestasYCalcularPuntaje() {
        // Mock de datos de entrada
        Long estudianteId = 1L;
        Long examenId = 2L;
        RespuestaDTO respuestas = new RespuestaDTO();
        int puntajeTotal = 42;
        // Configurar el servicio para devolver datos simulados
        when(respuestaService.recopilarRespuestasDeEstudianteEnExamen(estudianteId, examenId)).thenReturn(respuestas);
        when(respuestaService.calcularPuntajeTotal(respuestas)).thenReturn(puntajeTotal);

        // Llamar al método del controlador
        ResponseEntity<Map<String, Object>> responseEntity = respuestaController.recopilarRespuestasYCalcularPuntaje(estudianteId, examenId);

        // Verificar que se devuelva el código de estado esperado
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        // Verificar que la respuesta contenga las respuestas y el puntaje calculado
        Map<String, Object> responseBody = responseEntity.getBody();
        assertNotNull(responseBody.get("respuestas"));
        assertEquals(respuestas, responseBody.get("respuestas"));
        assertNotNull(responseBody.get("puntajeTotal"));
        assertEquals(puntajeTotal, (int) responseBody.get("puntajeTotal"));
    }
}
