package com.example.obrestdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombre(String Nombre);
    boolean existsByNombre(String nombre);
    boolean existsByEmail(String email);
}
