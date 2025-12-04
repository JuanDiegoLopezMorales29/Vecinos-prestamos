package com.example.objetos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("objetos")
public record Objeto(
        @Id Integer id,
        String nombre,
        String tipo,
        String estado
) {}
