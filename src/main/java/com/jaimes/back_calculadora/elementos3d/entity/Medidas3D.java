package com.jaimes.back_calculadora.elementos3d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Medidas3D")
public class Medidas3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double largo;
    private Double ancho;
    private Double alto;

    @OneToOne
    @JoinColumn(name = "elemento3d_id")
    @JsonIgnore
    private Elementos3D elemento3D;

    public Medidas3D() {
    }

    public Medidas3D(Integer id, Double largo, Double ancho, Double alto, Elementos3D elemento3D) {
        this.id = id;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.elemento3D = elemento3D;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public Double getAncho() {
        return ancho;
    }

    public void setAncho(Double ancho) {
        this.ancho = ancho;
    }

    public Double getAlto() {
        return alto;
    }

    public void setAlto(Double alto) {
        this.alto = alto;
    }

    public Elementos3D getElemento3D() {
        return elemento3D;
    }

    public void setElemento3D(Elementos3D elemento3D) {
        this.elemento3D = elemento3D;
    }
}
