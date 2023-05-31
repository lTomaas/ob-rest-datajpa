package com.example.obrestdatajpa.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.sql.Date;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LibroDto {
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private LocalDate fechaDeLanzamiento;
    private double precio;
}
