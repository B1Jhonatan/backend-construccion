package com.jaimes.back_calculadora.elemento3d.dto.output;

public class Elemento3dDTO {

    private Integer id;
    private String elemento;
    private Integer cantidad;
    private Double largo;
    private Double ancho;
    private Double alto;
    private Double areaUnitaria;
    private Double areaTotal;

    public Elemento3dDTO() {
    }

    public Elemento3dDTO(Integer id, String elemento, Integer cantidad, Double largo, Double ancho, Double alto, Double areaUnitaria, Double areaTotal) {
        this.id = id;
        this.elemento = elemento;
        this.cantidad = cantidad;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.areaUnitaria = areaUnitaria;
        this.areaTotal = areaTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Double getAreaUnitaria() {
        return areaUnitaria;
    }

    public void setAreaUnitaria(Double areaUnitaria) {
        this.areaUnitaria = areaUnitaria;
    }

    public Double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(Double areaTotal) {
        this.areaTotal = areaTotal;
    }
}
