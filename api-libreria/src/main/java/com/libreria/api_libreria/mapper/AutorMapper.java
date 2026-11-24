package com.libreria.api_libreria.mapper;

import com.libreria.api_libreria.dto.AutorDTO;
import com.libreria.api_libreria.entity.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

    public AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setIdAutor(autor.getIdAutor());
        dto.setNombre(autor.getNombre());
        dto.setPais(autor.getPais());
        return dto;
    }

    public Autor toEntity(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setIdAutor(dto.getIdAutor());
        autor.setNombre(dto.getNombre());
        autor.setPais(dto.getPais());
        return autor;
    }
}