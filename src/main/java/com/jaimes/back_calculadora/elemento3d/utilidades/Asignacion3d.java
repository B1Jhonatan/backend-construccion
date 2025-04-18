package com.jaimes.back_calculadora.elemento3d.utilidades;

import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.general.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.general.entity.Areas;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elemento3d.entity.Medidas3D;
import com.jaimes.back_calculadora.general.dto.input.TipoDTO;
import com.jaimes.back_calculadora.general.entity.Tipo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Asignacion3d {

    /*
    Toma un elementoDTO y lo transforma a mi entidad para poder almacenarlo en la base
    de datos
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
    resive un un elementoDTO para actualizar un elemento3D de la base de tatos, el metodo se encarga
    de mapear los elementos que vienen desde el frontend
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
    El elemento3D desde la base de datos y lo redefine en una entidad dto
    para su manejo en frontend
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


    /*
    Este metodo static transforma un elemento que viene desde la base de datos
    y lo devuelve como un elemento dto
    */
    public static TipoElementosDTO tipoElementosDTO(Tipo tipo) {
        TipoElementosDTO tipoElementosDTO = new TipoElementosDTO();
        tipoElementosDTO.setId(tipo.getId());
        tipoElementosDTO.setTipo(tipo.getTipo());
        List<Elemento3dDTO> listaDTO = new ArrayList<>();
        for (Elementos3D e : tipo.getElementos3D()) {
            Elemento3dDTO dto = new Elemento3dDTO();
            dto.setId(e.getId());
            dto.setElemento(e.getElemento3D()); // asumiendo que e.getElemento() es otra entidad
            dto.setCantidad(e.getCantidad());
            dto.setLargo(e.getMedidas().getLargo());
            dto.setAncho(e.getMedidas().getAncho());
            dto.setAlto(e.getMedidas().getAlto());
            dto.setAreaUnitaria(e.getAreas().getAreaUnidad());
            dto.setAreaTotal(e.getAreas().getAreaTotal());
            listaDTO.add(dto);
        }
        tipoElementosDTO.setElementos3D(listaDTO);
        return tipoElementosDTO;
    }

    public static TipoElementosDTO tipoElementosDtoOrdenadoName(Tipo tipo){
        TipoElementosDTO tipoElementosDTO = tipoElementosDTO(tipo);
        List<Elemento3dDTO> elemento3dDTO = tipoElementosDTO.getElementos3D();
        // Ordenar por nombre de elemento
        elemento3dDTO.sort(Comparator.comparing(Elemento3dDTO::getElemento));
        // Setear lista ordenada de nuevo en el DTO
        tipoElementosDTO.setElementos3D(elemento3dDTO);
        return tipoElementosDTO;
    }

}
