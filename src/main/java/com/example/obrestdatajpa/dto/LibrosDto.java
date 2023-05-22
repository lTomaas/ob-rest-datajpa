package com.example.obrestdatajpa.dto;

import com.example.obrestdatajpa.Libro;

import java.util.List;

public class LibrosDto {
    private List<Libro> libros;

    public LibrosDto() {
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
