package com.jaimes.back_calculadora.elemento3d.controller;

import com.jaimes.back_calculadora.general.dto.input.TipoDTO;
import com.jaimes.back_calculadora.elemento3d.service.Elemento3dService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elementos")
@CrossOrigin("*")
public class Elementos3dController {

    private final Elemento3dService elemento3dService;

    @Autowired
    public Elementos3dController(Elemento3dService elemento3dService) {
        this.elemento3dService = elemento3dService;
    }

    @GetMapping("/todos")
    public ResponseEntity<?> elementos3d() {
        return ResponseEntity.ok(elemento3dService.todosElementos3d());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardar(@RequestBody TipoDTO tipoDTO) {
        return ResponseEntity.ok(elemento3dService.guardarElemento3d(tipoDTO));
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(@RequestBody TipoDTO tipoDTO) {
        return ResponseEntity.ok(elemento3dService.actualizarElemento3d(tipoDTO));
    }

    @PostMapping("/eliminar/{id}")
    public ResponseEntity<String> elimirar(@PathVariable Integer id) {
        elemento3dService.eliminarElemento3d(id);
        return ResponseEntity.ok("Eliminado");
    }

    @PostMapping("/buscar/{id}")
    public ResponseEntity<?> findElementoById(@PathVariable Integer id) {
        return ResponseEntity.ok(elemento3dService.unElemetnoById(id));
    }

}
