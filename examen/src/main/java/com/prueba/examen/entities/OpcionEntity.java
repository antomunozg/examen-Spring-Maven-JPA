package com.prueba.examen.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "opcion")
public class OpcionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private boolean esCorrecta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pregunta_id")
    private PreguntaEntity pregunta;

    public OpcionEntity(Long id, String texto, boolean esCorrecta, PreguntaEntity pregunta) {
        this.id = id;
        this.texto = texto;
        this.esCorrecta = esCorrecta;
        this.pregunta = pregunta;
    }

}
