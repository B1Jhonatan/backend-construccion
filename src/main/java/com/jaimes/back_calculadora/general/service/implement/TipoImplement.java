package com.jaimes.back_calculadora.general.service.implement;

import com.jaimes.back_calculadora.general.dto.TipoListaDTO;
import com.jaimes.back_calculadora.general.entity.Tipo;
import com.jaimes.back_calculadora.general.repository.TipoRepository;
import com.jaimes.back_calculadora.general.service.TipoService;
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
}
