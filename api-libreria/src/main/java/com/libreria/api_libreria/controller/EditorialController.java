package com.libreria.api_libreria.controller;

import com.libreria.api_libreria.dto.EditorialDTO;
import com.libreria.api_libreria.service.EditorialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
@RequiredArgsConstructor
public class EditorialController {

    private final EditorialService editorialService;

    @GetMapping
    public ResponseEntity<List<EditorialDTO>> listar() {
        return ResponseEntity.ok(editorialService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EditorialDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(editorialService.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<EditorialDTO> crear(@Valid @RequestBody EditorialDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(editorialService.crear(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialDTO> actualizar(@PathVariable Integer id, @Valid @RequestBody EditorialDTO dto) {
        return ResponseEntity.ok(editorialService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        editorialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}