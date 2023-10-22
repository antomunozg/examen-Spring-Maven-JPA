package com.prueba.examen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estudiante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;
    private String ciudad;
    private String zonaHoraria;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "estudiante_examen",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "examen_id")
    )
    private List<Examen> examenesAsignados;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, int edad, String ciudad, String zonaHoraria, List<Examen> examenesAsignados) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.zonaHoraria = zonaHoraria;
        this.examenesAsignados = examenesAsignados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public List<Examen> getExamenesAsignados() {
        return examenesAsignados;
    }

    public void setExamenesAsignados(List<Examen> examenesAsignados) {
        this.examenesAsignados = examenesAsignados;
    }
}
