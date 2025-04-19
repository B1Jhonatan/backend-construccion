package com.jaimes.back_calculadora.general.service;

import com.jaimes.back_calculadora.general.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.general.dto.output.TipoListaDTO;

import java.util.List;

public interface TipoService {
    List<TipoListaDTO> todosTipos();
    TipoElementosDTO todosTipoElementos(Integer id);
    TipoElementosDTO tipoElementosSortName(Integer id);
    TipoElementosDTO tipoElementosSortAreaMayor(Integer id);
    TipoElementosDTO tipoElemetnosSortAreaMenor(Integer id);
}
