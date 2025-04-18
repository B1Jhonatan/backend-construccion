package com.jaimes.back_calculadora.general.dto.output;


import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;

import java.util.List;

public class TipoElementosDTO {

    private Integer id;
    private String Tipo;
    private List<Elemento3dDTO> elementos3D;

    public TipoElementosDTO() {
    }

    public TipoElementosDTO(Integer id, String tipo, List<Elemento3dDTO> elementos3D) {
        this.id = id;
        Tipo = tipo;
        this.elementos3D = elementos3D;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public List<Elemento3dDTO> getElementos3D() {
        return elementos3D;
    }

    public void setElementos3D(List<Elemento3dDTO> elementos3D) {
        this.elementos3D = elementos3D;
    }
}
