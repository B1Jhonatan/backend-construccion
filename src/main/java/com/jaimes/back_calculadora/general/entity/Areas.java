package com.jaimes.back_calculadora.general.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;
import jakarta.persistence.*;

@Entity
@Table(name = "Areas")
public class Areas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Double areaUnidad;
    private Double areaTotal;

    @OneToOne
    @JoinColumn(name = "elemento_id")
    @JsonIgnore
    private Elementos3D elemento3D;

    public Areas() {
    }

    public Areas(Integer id, Double areaUnidad, Double areaTotal, Elementos3D elemento3D) {
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
