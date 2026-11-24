package com.libreria.api_libreria.service;

import com.libreria.api_libreria.dto.AutorDTO;
import com.libreria.api_libreria.entity.Autor;
import com.libreria.api_libreria.mapper.AutorMapper;
import com.libreria.api_libreria.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;
    private final AutorMapper autorMapper;

    public List<AutorDTO> listarTodos() {
        return autorRepository.findAll().stream().map(autorMapper::toDTO).toList();
    }

    public AutorDTO obtenerPorId(Integer id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + id));
        return autorMapper.toDTO(autor);
    }

    public AutorDTO crear(AutorDTO dto) {
        Autor guardado = autorRepository.save(autorMapper.toEntity(dto));
        return autorMapper.toDTO(guardado);
    }

    public AutorDTO actualizar(Integer id, AutorDTO dto) {
        Autor existente = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + id));
        existente.setNombre(dto.getNombre());
        existente.setPais(dto.getPais());
        return autorMapper.toDTO(autorRepository.save(existente));
    }

    public void eliminar(Integer id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor no encontrado con ID: " + id);
        }
        autorRepository.deleteById(id);
    }
}