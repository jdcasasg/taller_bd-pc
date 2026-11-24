package com.libreria.api_libreria.service;

import com.libreria.api_libreria.dto.EditorialDTO;
import com.libreria.api_libreria.entity.Editorial;
import com.libreria.api_libreria.mapper.EditorialMapper;
import com.libreria.api_libreria.repository.EditorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EditorialService {

    private final EditorialRepository editorialRepository;
    private final EditorialMapper editorialMapper;

    public List<EditorialDTO> listarTodos() {
        return editorialRepository.findAll().stream().map(editorialMapper::toDTO).toList();
    }

    public EditorialDTO obtenerPorId(Integer id) {
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada con ID: " + id));
        return editorialMapper.toDTO(editorial);
    }

    public EditorialDTO crear(EditorialDTO dto) {
        Editorial guardada = editorialRepository.save(editorialMapper.toEntity(dto));
        return editorialMapper.toDTO(guardada);
    }

    public EditorialDTO actualizar(Integer id, EditorialDTO dto) {
        Editorial existente = editorialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada con ID: " + id));
        existente.setNombre(dto.getNombre());
        existente.setPais(dto.getPais());
        return editorialMapper.toDTO(editorialRepository.save(existente));
    }

    public void eliminar(Integer id) {
        if (!editorialRepository.existsById(id)) {
            throw new RuntimeException("Editorial no encontrada con ID: " + id);
        }
        editorialRepository.deleteById(id);
    }
}