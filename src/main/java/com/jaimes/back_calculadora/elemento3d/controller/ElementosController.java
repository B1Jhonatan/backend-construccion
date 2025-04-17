package com.jaimes.back_calculadora.elemento3d.controller;

import com.jaimes.back_calculadora.elemento3d.dto.input.ElementoDTO;
import com.jaimes.back_calculadora.elemento3d.service.Elemento3dService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elementos")
@CrossOrigin("*")
public class ElementosController {

    private final Elemento3dService elemento3dService;

    @Autowired
    public ElementosController(Elemento3dService elemento3dService) {
        this.elemento3dService = elemento3dService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> elementos3d(){
        return ResponseEntity.ok(elemento3dService.todosElementos3d());
    }

    @PostMapping("/tipo/{id}")
    public ResponseEntity<?> tipo(@PathVariable Integer id){
        return ResponseEntity.ok(elemento3dService.todosTipoElementos(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody ElementoDTO elementoDTO){
        return ResponseEntity.ok(elemento3dService.guardarElemento3d(elementoDTO));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody ElementoDTO elementoDTO){
        return ResponseEntity.ok(elemento3dService.actualizarElemento3d(elementoDTO));
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> elimirar (@PathVariable Integer id){
        elemento3dService.eliminarElemento3d(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PostMapping("/buscar/{id}")
    public ResponseEntity<?> findElementoById(@PathVariable Integer id){
        return ResponseEntity.ok(elemento3dService.unElemetnoById(id));
    }

}
