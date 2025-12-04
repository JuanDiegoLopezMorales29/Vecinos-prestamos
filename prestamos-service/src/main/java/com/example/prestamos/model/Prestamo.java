package com.example.prestamos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Table("prestamos")
public record Prestamo(
        @Id Integer id,
        String prestador,
        String receptor,
        @Column("objeto_id") Integer objetoId,
        @Column("fecha_prestamo") LocalDate fechaPrestamo
) {}
