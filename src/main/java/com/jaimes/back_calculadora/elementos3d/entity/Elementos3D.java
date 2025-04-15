package com.jaimes.back_calculadora.elementos3d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaimes.back_calculadora.entity.Tipo;
import jakarta.persistence.*;

@Entity
@Table(name = "Elementos3D")
public class Elementos3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String elemento3D;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "tipo_id")
    @JsonIgnore
    private Tipo tipo;

    @OneToOne(mappedBy = "elemento3D", cascade = CascadeType.ALL, orphanRemoval = true)
    private Medidas3D medidas;

    @OneToOne(mappedBy = "elemento3D", cascade = CascadeType.ALL, orphanRemoval = true)
    private Areas3D areas;

    public Elementos3D() {
    }

    public Elementos3D(Integer id, String elemento3D, Integer cantidad, Tipo tipo, Medidas3D medidas, Areas3D areas) {
        this.id = id;
        this.elemento3D = elemento3D;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.medidas = medidas;
        this.areas = areas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElemento3D() {
        return elemento3D;
    }

    public void setElemento3D(String elemento3D) {
        this.elemento3D = elemento3D;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Medidas3D getMedidas() {
        return medidas;
    }

    public void setMedidas(Medidas3D medidas) {
        this.medidas = medidas;
    }

    public Areas3D getAreas() {
        return areas;
    }

    public void setAreas(Areas3D areas) {
        this.areas = areas;
    }
}
