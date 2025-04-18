package com.jaimes.back_calculadora.general.controller;

import com.jaimes.back_calculadora.elemento3d.service.Elemento3dService;
import com.jaimes.back_calculadora.elemento3d.dto.input.MedidasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/medidas")
public class AreaController {

    private final Elemento3dService elemento3dService;

    @Autowired
    public AreaController(Elemento3dService elemento3dService) {
        this.elemento3dService = elemento3dService;
    }

    @PostMapping("/calcular")
    public ResponseEntity<?> areas(@RequestBody MedidasDTO medidasDTO){
        return ResponseEntity.ok(elemento3dService.area3D(medidasDTO));
    }

}
