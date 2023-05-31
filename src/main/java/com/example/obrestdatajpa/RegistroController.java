package com.example.obrestdatajpa;


import com.example.obrestdatajpa.dto.RegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RegistroController {

    private final UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("api/auth/registro")
    public String mostrarForm(){

        return "registro";
    }

    @PostMapping("api/auth/registrar")
    public String registrar(@ModelAttribute RegisterDto registerDto, Model model){
        model.addAttribute("registro", registerDto);
        //Usuario usuario = new Usuario(null,registerDto.getNombre(),registerDto.getEmail(),registerDto.getContraseña(),false,true);
        if(usuarioRepository.existsByNombre(registerDto.getNombre()))
            return "registro";
        if(usuarioRepository.existsByEmail(registerDto.getEmail()))
            return "registro";

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(registerDto.getNombre());
        nuevoUsuario.setContraseña(passwordEncoder.encode((registerDto.getContraseña())));
        nuevoUsuario.setEmail(registerDto.getNombre());

        usuarioRepository.save(nuevoUsuario);
        return "login";
    }

    /*
    @PostMapping(consumes =  MediaType.APPLICATION_JSON_VALUE)
    //@RequestBody RegisterDto registerDto
    public ResponseEntity<String> registro(ModelAttribute Usuario usuario){

        if (usuarioRepository.existsByNombre(registerDto.getNombre())) {
            return new ResponseEntity<>("El nombre de usuario ya esta ocupado!", HttpStatus.BAD_REQUEST);
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre(registerDto.getNombre());
        nuevoUsuario.setContraseña(passwordEncoder.encode((registerDto.getContraseña())));
        nuevoUsuario.setEmail(registerDto.getNombre());

        usuarioRepository.save(nuevoUsuario);

        return new ResponseEntity<>("Usuario registrado con exito!", HttpStatus.OK);
    }

     */


}
