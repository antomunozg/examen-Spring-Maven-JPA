package com.prueba.examen.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RespuestaHttpDTO {

    private HttpStatus status;

    private String mensaje;

    private Object contenido;

}
