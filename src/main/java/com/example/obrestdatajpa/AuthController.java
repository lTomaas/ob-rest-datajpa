package com.example.obrestdatajpa;

import com.example.obrestdatajpa.dto.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto){
        /*
        if(usuarioRepository.existsByNombre(registerDto.getNombre())){
            return new ResponseEntity<>("El nombre de usuario ya está en uso", HttpStatus.BAD_REQUEST);
        }

        if(usuarioRepository.existsByEmail(registerDto.getEmail())){
            return new ResponseEntity<>("El email ya está en uso", HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario();

        usuario.setNombre(registerDto.getNombre());
        usuario.setContraseña(passwordEncoder.encode(registerDto.getContraseña()));
        //usuario.setContraseña((registerDto.getContraseña()));
        usuario.setEmail(registerDto.getEmail());

        usuarioRepository.save(usuario);

        */

        //return new ResponseEntity<>("Usuario registrado con exito",HttpStatus.OK);
        return "FUNCIONA";
    }


}
