package com.libreria.api_libreria.service;

import com.libreria.api_libreria.dto.LibroDTO;
import com.libreria.api_libreria.entity.Autor;
import com.libreria.api_libreria.entity.Editorial;
import com.libreria.api_libreria.entity.Libro;
import com.libreria.api_libreria.mapper.LibroMapper;
import com.libreria.api_libreria.repository.AutorRepository;
import com.libreria.api_libreria.repository.EditorialRepository;
import com.libreria.api_libreria.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final EditorialRepository editorialRepository;
    private final LibroMapper libroMapper;

    public List<LibroDTO> listarTodos() {
        return libroRepository.findAll().stream().map(libroMapper::toDTO).toList();
    }

    public LibroDTO obtenerPorId(Integer id) {
        Libro libro = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
        return libroMapper.toDTO(libro);
    }

    public LibroDTO crear(LibroDTO dto) {
        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepository.findById(dto.getIdEditorial())
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        Libro guardado = libroRepository.save(libroMapper.toEntity(dto, autor, editorial));
        return libroMapper.toDTO(guardado);
    }

    public LibroDTO actualizar(Integer id, LibroDTO dto) {
        Libro existente = libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
        Autor autor = autorRepository.findById(dto.getIdAutor())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        Editorial editorial = editorialRepository.findById(dto.getIdEditorial())
                .orElseThrow(() -> new RuntimeException("Editorial no encontrada"));

        existente.setTitulo(dto.getTitulo());
        existente.setFechaPublicacion(dto.getFechaPublicacion());
        existente.setAutor(autor);
        existente.setEditorial(editorial);
        return libroMapper.toDTO(libroRepository.save(existente));
    }

    public void eliminar(Integer id) {
        if (!libroRepository.existsById(id)) {
            throw new RuntimeException("Libro no encontrado con ID: " + id);
        }
        libroRepository.deleteById(id);
    }
}