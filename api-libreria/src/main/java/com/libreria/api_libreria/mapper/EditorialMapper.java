package com.libreria.api_libreria.mapper;

import com.libreria.api_libreria.dto.EditorialDTO;
import com.libreria.api_libreria.entity.Editorial;
import org.springframework.stereotype.Component;

@Component
public class EditorialMapper {

    public EditorialDTO toDTO(Editorial editorial) {
        EditorialDTO dto = new EditorialDTO();
        dto.setIdEditorial(editorial.getIdEditorial());
        dto.setNombre(editorial.getNombre());
        dto.setPais(editorial.getPais());
        return dto;
    }

    public Editorial toEntity(EditorialDTO dto) {
        Editorial editorial = new Editorial();
        editorial.setIdEditorial(dto.getIdEditorial());
        editorial.setNombre(dto.getNombre());
        editorial.setPais(dto.getPais());
        return editorial;
    }
}