package com.jaimes.back_calculadora.general.controller;

import com.jaimes.back_calculadora.general.service.TipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    private final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    //Lista los tipos solo con id y nombre
    @GetMapping("/lista")
    public ResponseEntity<?> elementos(){
        return ResponseEntity.ok(tipoService.todosTipos());
    }

    //Se obtienen todos los elementos de un tipo
    @PostMapping("/elementos/{id}")
    public ResponseEntity<?> tipo(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.todosTipoElementos(id));
    }

    //Ordena los elementos por nombre
    @PostMapping("/ordenar/{id}")
    public ResponseEntity<?> ordenarName(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.tiposElementosSort(id));
    }

    //Ordena los elementos por area total

    //Ordena los elementos por area unitaria
}
