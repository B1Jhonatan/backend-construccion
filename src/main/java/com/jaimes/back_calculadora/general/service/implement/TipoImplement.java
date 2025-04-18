package com.jaimes.back_calculadora.general.service.implement;

import com.jaimes.back_calculadora.elemento3d.utilidades.Asignacion3d;
import com.jaimes.back_calculadora.general.dto.output.TipoElementosDTO;
import com.jaimes.back_calculadora.general.dto.output.TipoListaDTO;
import com.jaimes.back_calculadora.general.entity.Tipo;
import com.jaimes.back_calculadora.general.repository.TipoRepository;
import com.jaimes.back_calculadora.general.service.TipoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TipoImplement implements TipoService {

    private final TipoRepository tipoRepository;

    @Autowired
    public TipoImplement(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    //Extrae la lista de tipos para ordenar en una lista solo devuelde id y nombre
    @Override
    public List<TipoListaDTO> todosTipos() {
        List<Tipo> elementosDb = tipoRepository.findAll();
        List<TipoListaDTO> tipoListaDTOS = new ArrayList<>();
        for (Tipo e : elementosDb){
            TipoListaDTO dto = new TipoListaDTO(e.getId(), e.getTipo());
            tipoListaDTOS.add(dto);
        }
        return tipoListaDTOS;
    }

    //Ordena los elementos por nombre
    @Override
    public TipoElementosDTO tiposElementosSort(Integer id) {
        Tipo tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el elemento"));
        return Asignacion3d.tipoElementosDtoOrdenadoName(tipo);
    }

    //Extrae el tipo y los elementos
    @Override
    public TipoElementosDTO todosTipoElementos(Integer id) {
        Tipo tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el elemento"));
        return Asignacion3d.tipoElementosDTO(tipo);
    }


}
