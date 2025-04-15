package com.jaimes.back_calculadora.elementos3d.dto.output;

public class TipoListaDTO {

    private Integer id;
    private String elemento;

    public TipoListaDTO() {
    }

    public TipoListaDTO(Integer id, String elemento) {
        this.id = id;
        this.elemento = elemento;
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
}
