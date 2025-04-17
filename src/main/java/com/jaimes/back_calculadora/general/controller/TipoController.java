package com.jaimes.back_calculadora.general.controller;

import com.jaimes.back_calculadora.general.service.TipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping("/lista")
    public ResponseEntity<?> elementos(){
        return ResponseEntity.ok(tipoService.todosTipos());
    }
}
