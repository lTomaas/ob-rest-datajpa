package com.example.obrestdatajpa;


import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String contraseña;

    public Usuario(){

    }

    public Usuario(String nombre, String email, String contraseña){
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }
}
