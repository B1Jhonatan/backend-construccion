package com.jaimes.back_calculadora.elementos3d.controller;

import com.jaimes.back_calculadora.elementos3d.service.ElementoService;
import com.jaimes.back_calculadora.elementos3d.dto.input.MedidasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/medidas")
public class AreaController {

    private final ElementoService elementoService;

    @Autowired
    public AreaController(ElementoService elementoService) {
        this.elementoService = elementoService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> areas(@RequestBody MedidasDTO medidasDTO){
        return ResponseEntity.ok(elementoService.area3D(medidasDTO));
    }

}
