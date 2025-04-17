package com.jaimes.back_calculadora.elemento3d.dto.input;

public class ElementoDTO {

    private Integer idTipo;
    private String tipo;
    private Integer idElemento;
    private String elemento;
    private Integer cantidad;
    private Double largo;
    private Double ancho;
    private Double alto;
    private Double areaUnidad;
    private Double areaTotal;

    public ElementoDTO() {
    }

    public ElementoDTO(Integer idTipo, String tipo, Integer idElemento, String elemento, Integer cantidad, Double largo, Double ancho, Double alto, Double areaUnidad, Double areaTotal) {
        this.idTipo = idTipo;
        this.tipo = tipo;
        this.idElemento = idElemento;
        this.elemento = elemento;
        this.cantidad = cantidad;
        this.largo = largo;
        this.ancho = ancho;
        this.alto = alto;
        this.areaUnidad = areaUnidad;
        this.areaTotal = areaTotal;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
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
}
