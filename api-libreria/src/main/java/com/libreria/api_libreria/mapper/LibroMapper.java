package com.libreria.api_libreria.mapper;

import com.libreria.api_libreria.dto.LibroDTO;
import com.libreria.api_libreria.entity.Autor;
import com.libreria.api_libreria.entity.Editorial;
import com.libreria.api_libreria.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    public LibroDTO toDTO(Libro libro) {
        LibroDTO dto = new LibroDTO();
        dto.setIdLibro(libro.getIdLibro());
        dto.setTitulo(libro.getTitulo());
        dto.setFechaPublicacion(libro.getFechaPublicacion());
        if (libro.getAutor() != null) {
            dto.setIdAutor(libro.getAutor().getIdAutor());
        }
        if (libro.getEditorial() != null) {
            dto.setIdEditorial(libro.getEditorial().getIdEditorial());
        }
        return dto;
    }

    public Libro toEntity(LibroDTO dto, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        libro.setIdLibro(dto.getIdLibro());
        libro.setTitulo(dto.getTitulo());
        libro.setFechaPublicacion(dto.getFechaPublicacion());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        return libro;
    }
}