package com.prueba.examen.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Opcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private boolean esCorrecta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private Pregunta pregunta;

    public Opcion(Long id, String texto, boolean esCorrecta, Pregunta pregunta) {
        this.id = id;
        this.texto = texto;
        this.esCorrecta = esCorrecta;
        this.pregunta = pregunta;
    }

}
