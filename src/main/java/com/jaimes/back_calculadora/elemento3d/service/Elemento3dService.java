package com.jaimes.back_calculadora.elemento3d.service;

import com.jaimes.back_calculadora.general.dto.input.TipoDTO;
import com.jaimes.back_calculadora.elemento3d.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.general.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;

import java.util.List;

public interface Elemento3dService {

    AreasDTO area3D(MedidasDTO medidasDTO);
    List<Elementos3D> todosElementos3d();
    Elemento3dDTO unElemetnoById(Integer id);
    Elementos3D guardarElemento3d(TipoDTO tipoDTO);
    Elementos3D actualizarElemento3d(TipoDTO tipoDTO);
    void eliminarElemento3d(Integer id);

}
