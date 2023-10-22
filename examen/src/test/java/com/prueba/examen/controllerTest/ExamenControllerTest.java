package com.prueba.examen.controllerTest;

import com.prueba.examen.ExamenApplication;
import com.prueba.examen.controllers.ExamenController;
import com.prueba.examen.entities.ExamenEntity;
import com.prueba.examen.services.ExamenService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.prueba.examen.dto.ExamenDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@SpringBootTest(classes = ExamenApplication.class)
public class ExamenControllerTest {

    @Mock
    private ExamenService examenService;

    private ExamenController examenController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        examenController = new ExamenController(examenService);
    }

    @Test
    public void testCrearExamen() {
        // Datos de prueba
        ExamenDTO examenDTO = new ExamenDTO();
        examenDTO.setNombre("Examen de Prueba");
        examenDTO.setFechaPresentacion(LocalDateTime.now());
        examenDTO.setPuntajeTotal(100);

        ExamenEntity examenCreado = new ExamenEntity();

        // Mock del servicio de examen
        Mockito.when(examenService.crearExamen(Mockito.any(ExamenDTO.class))).thenReturn(examenCreado);

        // Llamar al método del controlador
        ResponseEntity<ExamenEntity> response = examenController.crearExamen(examenDTO);

        // Verificar la respuesta
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(examenCreado);
    }

}
