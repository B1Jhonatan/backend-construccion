package com.jaimes.back_calculadora.elemento3d.utilidades;

import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.general.entity.Areas;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elemento3d.entity.Medidas3D;
import com.jaimes.back_calculadora.general.dto.input.TipoDTO;
import com.jaimes.back_calculadora.general.entity.Tipo;


public class Asignacion3d {

    /*
    Toma un elementoDTO y lo transforma a mi entidad para poder almacenarlo en la base
    de datos.
     */
    public static Elementos3D elementos3dGuardar(TipoDTO tipoDTO){
        Elementos3D elementos3D = new Elementos3D();
        Tipo tipo = new Tipo();
        tipo.setId(tipoDTO.getIdTipo());
        tipo.setTipo(tipoDTO.getTipo());
        elementos3D.setElemento3D(tipoDTO.getElemento());
        elementos3D.setCantidad(tipoDTO.getCantidad());
        elementos3D.setTipo(tipo);
        Medidas3D medidas3D = new Medidas3D();
        medidas3D.setLargo(tipoDTO.getLargo());
        medidas3D.setAncho(tipoDTO.getAncho());
        medidas3D.setAlto(tipoDTO.getAlto());
        medidas3D.setElemento3D(elementos3D);
        elementos3D.setMedidas(medidas3D);
        Areas areas = new Areas();
        areas.setAreaUnidad(tipoDTO.getAreaUnidad());
        areas.setAreaTotal(tipoDTO.getAreaTotal());
        areas.setElemento3D(elementos3D);
        elementos3D.setAreas(areas);
        return elementos3D;
    }


    /*
    resive un elementoDTO para actualizar un elemento3D de la base de tatos, el metodo se encarga
    de mapear los elementos que vienen desde el frontend.
     */
    public static Elementos3D elementos3dActualizar(TipoDTO tipoDTO, Elementos3D elementos3D){
        elementos3D.setElemento3D(tipoDTO.getElemento());
        elementos3D.setCantidad(tipoDTO.getCantidad());
        Medidas3D medidas3D = elementos3D.getMedidas();
        medidas3D.setLargo(tipoDTO.getLargo());
        medidas3D.setAncho(tipoDTO.getAncho());
        medidas3D.setAlto(tipoDTO.getAlto());
        medidas3D.setElemento3D(elementos3D);
        Areas areas = elementos3D.getAreas();
        areas.setAreaUnidad(tipoDTO.getAreaUnidad());
        areas.setAreaTotal(tipoDTO.getAreaTotal());
        areas.setElemento3D(elementos3D);
        elementos3D.setMedidas(medidas3D);
        elementos3D.setMedidas(medidas3D);
        elementos3D.setAreas(areas);
        return elementos3D;
    }


    /*
    El elemento3D desde la base de datos y lo redefine en una entidad dto.
    Para su manejo en frontend.
     */
    public static Elemento3dDTO convertirElemento3dDTO(Elementos3D elementos3D){
        Elemento3dDTO elemento3dDTO = new Elemento3dDTO();
        elemento3dDTO.setId(elementos3D.getId());
        elemento3dDTO.setElemento(elementos3D.getElemento3D());
        elemento3dDTO.setCantidad(elementos3D.getCantidad());
        elemento3dDTO.setLargo(elementos3D.getMedidas().getLargo());
        elemento3dDTO.setAncho(elementos3D.getMedidas().getAncho());
        elemento3dDTO.setAlto(elementos3D.getMedidas().getAlto());
        elemento3dDTO.setAreaUnitaria(elementos3D.getAreas().getAreaUnidad());
        elemento3dDTO.setAreaTotal(elementos3D.getAreas().getAreaTotal());
        return elemento3dDTO;
    }

}
