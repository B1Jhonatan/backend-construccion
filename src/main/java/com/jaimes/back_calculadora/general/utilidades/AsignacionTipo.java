package com.jaimes.back_calculadora.general.utilidades;

import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;
import com.jaimes.back_calculadora.general.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.general.entity.Tipo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AsignacionTipo {

    /*
    Este metodo static transforma un elemento que viene desde la base de datos
    y lo devuelve como un elemento dto.
    */
    public static TipoElementosDTO tipoElementosDTO(Tipo tipo) {
        TipoElementosDTO tipoElementosDTO = new TipoElementosDTO();
        tipoElementosDTO.setId(tipo.getId());
        tipoElementosDTO.setTipo(tipo.getTipo());
        List<Elemento3dDTO> listaDTO = new ArrayList<>();
        for (Elementos3D e : tipo.getElementos3D()) {
            Elemento3dDTO dto = new Elemento3dDTO();
            dto.setId(e.getId());
            dto.setElemento(e.getElemento3D()); // asumiendo que e.getElemento() es otra entidad.
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

    /*
    Ordena los elemetos por nombre y se usa en el service de tipo.
     */
    public static TipoElementosDTO tipoElementosDtoOrdenadoName(Tipo tipo){
        TipoElementosDTO tipoElementosDTO = tipoElementosDTO(tipo);
        List<Elemento3dDTO> elemento3dDTO = tipoElementosDTO.getElementos3D();
        // Ordenar por nombre de elemento.
        elemento3dDTO.sort(Comparator.comparing(Elemento3dDTO::getElemento));
        // Setear lista ordenada de nuevo en el DTO.
        tipoElementosDTO.setElementos3D(elemento3dDTO);
        return tipoElementosDTO;
    }

    /*
    Ordena los elementos por area de mayor a menor.
     */
    public static TipoElementosDTO tipoElementosDtoSortAreaMayor(Tipo tipo){
        TipoElementosDTO tipoElementosDTO = tipoElementosDTO(tipo);
        List<Elemento3dDTO> elemento3dDTO = tipoElementosDTO.getElementos3D();
        elemento3dDTO.sort(Comparator.comparing(Elemento3dDTO::getAreaTotal,
                Comparator.nullsLast(Double::compareTo)).reversed());
        tipoElementosDTO.setElementos3D(elemento3dDTO);
        return tipoElementosDTO;
    }

    /*
    Ordena los elementos por area de menor a mayor.
     */
    public  static TipoElementosDTO tipoElementosDtoSortAreaMenor(Tipo tipo){
        TipoElementosDTO tipoElementosDTO = tipoElementosDTO(tipo);
        List<Elemento3dDTO> elemento3dDTO = tipoElementosDTO.getElementos3D();
        elemento3dDTO.sort(Comparator.comparing(Elemento3dDTO::getAreaTotal,
                Comparator.nullsLast(Double::compareTo)));
        tipoElementosDTO.setElementos3D(elemento3dDTO);
        return tipoElementosDTO;
    }

}
