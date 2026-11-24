package com.libreria.api_libreria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorDTO {
    private Integer idAutor;

    @NotBlank(message = "El nombre del autor es obligatorio")
    private String nombre;

    private String pais;
}