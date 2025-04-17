package com.jaimes.back_calculadora.elemento2d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaimes.back_calculadora.general.entity.Areas;
import jakarta.persistence.*;

@Entity
@Table(name = "Medidas2D")
public class Medidas2D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double largo;
    private Double ancho;

    @OneToOne
    @JoinColumn(name = "elemento_id")
    @JsonIgnore
    private Areas areas;

}
