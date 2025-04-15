package com.jaimes.back_calculadora.elementos3d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Areas3D")
public class Areas3D {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double areaUnidad;
    private Double areaTotal;

    @OneToOne
    @JoinColumn(name = "elemento3d_id")
    @JsonIgnore
    private Elementos3D elemento3D;

    public Areas3D() {
    }

    public Areas3D(Integer id, Double areaUnidad, Double areaTotal, Elementos3D elemento3D) {
        this.id = id;
        this.areaUnidad = areaUnidad;
        this.areaTotal = areaTotal;
        this.elemento3D = elemento3D;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAreaUnidad() {
        return areaUnidad;
    }

    public void setAreaUnidad(Double areaUnidad) {
        this.areaUnidad = areaUnidad;
    }

    public Double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Double areaTotal) {
        this.areaTotal = areaTotal;
    }

    public Elementos3D getElemento3D() {
        return elemento3D;
    }

    public void setElemento3D(Elementos3D elemento3D) {
        this.elemento3D = elemento3D;
    }
}
