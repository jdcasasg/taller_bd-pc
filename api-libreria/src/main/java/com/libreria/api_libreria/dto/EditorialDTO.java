package com.libreria.api_libreria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EditorialDTO {
    private Integer idEditorial;

    @NotBlank(message = "El nombre de la editorial es obligatorio")
    private String nombre;

    private String pais;
}