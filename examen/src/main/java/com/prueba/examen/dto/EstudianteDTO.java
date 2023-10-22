package com.prueba.examen.dto;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.util.List;
@NoArgsConstructor
@Data
public class EstudianteDTO {


    private Long id;
    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;

    @Transient
    private List<ExamenDTO> examenesAsignados;

    public EstudianteDTO(Long id, String zonaHoraria) {
        this.id = id;
        this.zonaHoraria = zonaHoraria;
    }

    public EstudianteDTO(Long id, String nombre, int edad, String ciudad, String zonaHoraria, List<ExamenDTO> examenesAsignados) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
        this.examenesAsignados = examenesAsignados;
    }

    public EstudianteDTO(Long id, String nombre, int edad, String ciudad, String zonaHoraria) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
    }

}
