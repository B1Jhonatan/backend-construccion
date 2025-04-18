package com.jaimes.back_calculadora.elemento3d.service.Implement;

import com.jaimes.back_calculadora.elemento3d.dto.output.Elemento3dDTO;
import com.jaimes.back_calculadora.elemento3d.utilidades.Asignacion3d;
import com.jaimes.back_calculadora.general.utilidades.Constantes;
import com.jaimes.back_calculadora.general.dto.input.TipoDTO;
import com.jaimes.back_calculadora.elemento3d.dto.input.MedidasDTO;
import com.jaimes.back_calculadora.general.dto.output.AreasDTO;
import com.jaimes.back_calculadora.elemento3d.entity.Elementos3D;
import com.jaimes.back_calculadora.elemento3d.repository.Elemento3dRepository;
import com.jaimes.back_calculadora.elemento3d.service.Elemento3dService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Elemento3dImplement implements Elemento3dService {

    private final Elemento3dRepository elemento3dRepository;

    @Autowired
    public Elemento3dImplement(Elemento3dRepository elemento3dRepository) {
        this.elemento3dRepository = elemento3dRepository;
    }

    @Override
    public AreasDTO area3D(MedidasDTO medidasDTO) {
        AreasDTO areasDTO = new AreasDTO();
        double areaUnidad = ((medidasDTO.getLargo() * Constantes.METROS_A_MILIMETROS)
                * (medidasDTO.getAncho() * Constantes.METROS_A_MILIMETROS)
                * (medidasDTO.getAlto() * Constantes.METROS_A_MILIMETROS)
                / Constantes.MILIMETROS3_A_METROS3);
        double areaTotal = areaUnidad * medidasDTO.getCantidad();
        areasDTO.setAreaUnidad(areaUnidad);
        areasDTO.setAreaTotal(areaTotal);
        return areasDTO;
    }

    @Override
    public Elementos3D guardarElemento3d(TipoDTO tipoDTO) {
        Elementos3D elementos3D = Asignacion3d.elementos3dGuardar(tipoDTO);
        return elemento3dRepository.save(elementos3D);
    }

    @Override
    public Elementos3D actualizarElemento3d(TipoDTO tipoDTO) {
        Elementos3D elementos3D = elemento3dRepository.findById(tipoDTO.getIdElemento())
                .orElseThrow(() -> new EntityNotFoundException("Elemento3D no encontrado"));;
        elementos3D = Asignacion3d.elementos3dActualizar(tipoDTO, elementos3D);
        return elemento3dRepository.save(elementos3D);
    }

    @Override
    public void eliminarElemento3d(Integer id) {
        elemento3dRepository.deleteById(id);
    }

    @Override
    public List<Elementos3D> todosElementos3d() {
        return elemento3dRepository.findAll();
    }

    @Override
    public Elemento3dDTO unElemetnoById(Integer id) {
        Elementos3D elementos3D = elemento3dRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el elemento"));
        return Asignacion3d.convertirElemento3dDTO(elementos3D);
    }

}
