package com.libreria.api_libreria.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class LibroDTO {
    private Integer idLibro;

    @NotBlank(message = "El título del libro es obligatorio")
    private String titulo;

    private LocalDate fechaPublicacion;

    @NotNull(message = "El idAutor es obligatorio")
    private Integer idAutor;

    @NotNull(message = "El idEditorial es obligatorio")
    private Integer idEditorial;
}