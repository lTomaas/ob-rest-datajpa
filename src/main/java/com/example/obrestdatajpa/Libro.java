package com.example.obrestdatajpa;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "\"Libros\"")
public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ISBN;
    private String genero;
    private LocalDate fechaDeLanzamiento;
    private double precio;


    public Libro() {

    }

    public Libro(String titulo, String autor, String editorial, String genero, LocalDate fechaDeLanzamiento, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setFechaDeLanzamiento(LocalDate fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
