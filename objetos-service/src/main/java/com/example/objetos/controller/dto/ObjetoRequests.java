package com.example.objetos.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class ObjetoRequests {
    public record Create(@NotBlank String nombre,
                         @NotBlank String tipo,
                         @NotBlank String estado) {}
    public record Update(@NotBlank String nombre,
                         @NotBlank String tipo,
                         @NotBlank String estado) {}
}
