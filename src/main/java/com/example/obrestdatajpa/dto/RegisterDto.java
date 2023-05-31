package com.example.obrestdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegisterDto {
    private String email;
    private String nombre;
    private String contraseña;
}
