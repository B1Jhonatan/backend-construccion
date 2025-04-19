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

    //Lista los tipos solo con ID y nombre.
    @GetMapping("/lista")
    public ResponseEntity<?> elementos(){
        return ResponseEntity.ok(tipoService.todosTipos());
    }

    //Se obtienen todos los elementos de un tipo.
    @GetMapping("/{id}/elementos")
    public ResponseEntity<?> tipo(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.todosTipoElementos(id));
    }

    //Ordena los elementos por nombre.
    @GetMapping("/{id}/ordenar-nombre")
    public ResponseEntity<?> ordenarName(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.tipoElementosSortName(id));
    }

    //Ordena los elementos por area mayor a menor.
    @GetMapping("/{id}/ordenar-area-mayor")
    public ResponseEntity<?> ordenarAreaMayor(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.tipoElementosSortAreaMayor(id));
    }

    //Ordena los elementos por area menor a mayor.
    @GetMapping("/{id}/ordenar-area-menor")
    public ResponseEntity<?> ordenarAreaMenor(@PathVariable Integer id){
        return ResponseEntity.ok(tipoService.tipoElemetnosSortAreaMenor(id));
    }

}
