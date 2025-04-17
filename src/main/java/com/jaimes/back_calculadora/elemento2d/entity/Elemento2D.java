package com.jaimes.back_calculadora.elemento2d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaimes.back_calculadora.general.entity.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "Elemento2D")
public class Elemento2D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento2D;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonIgnore
    private Tipo tipo;

}
