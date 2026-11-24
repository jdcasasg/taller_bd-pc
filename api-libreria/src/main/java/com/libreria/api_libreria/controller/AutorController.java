package com.libreria.api_libreria.controller;

import com.libreria.api_libreria.dto.AutorDTO;
import com.libreria.api_libreria.service.AutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/autores")
@RequiredArgsConstructor
public class AutorController {

    private final AutorService autorService;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> listar() {
        return ResponseEntity.ok(autorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(autorService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AutorDTO> crear(@Valid @RequestBody AutorDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody AutorDTO dto) {
        return ResponseEntity.ok(autorService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        autorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}