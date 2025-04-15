package com.jaimes.back_calculadora.entity;

import com.jaimes.back_calculadora.elementos3d.entity.Elementos3D;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tipos")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String tipo;

    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Elementos3D> elementos3D;

    public Tipo() {
    }

    public Tipo(List<Elementos3D> elementos3D, String tipo, Integer id) {
        this.elementos3D = elementos3D;
        this.tipo = tipo;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Elementos3D> getElementos3D() {
        return elementos3D;
    }

    public void setElementos3D(List<Elementos3D> elementos3D) {
        this.elementos3D = elementos3D;
    }
}
