package com.example.obrestdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;


    @RequestMapping("/users/new")
    public String nuevoUsuario(Model model){
        model.addAttribute("nuevoUsuario", new Usuario());

        return "users/user";
    }


}
