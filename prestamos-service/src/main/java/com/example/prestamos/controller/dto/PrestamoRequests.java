package com.example.prestamos.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PrestamoRequests {
    public record Create(@NotBlank String prestador,
                         @NotBlank String receptor,
                         @NotNull Integer objetoId,
                         @NotNull LocalDate fechaPrestamo) {}
    public record Update(@NotBlank String prestador,
                         @NotBlank String receptor,
                         @NotNull Integer objetoId,
                         @NotNull LocalDate fechaPrestamo) {}
}
