package com.example.obrestdatajpa;

import com.example.obrestdatajpa.dto.LibroDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
public class LibroController {
    private LibroRepository repository;

    private final Logger log = LoggerFactory.getLogger(LibroController.class);

    public LibroController(LibroRepository repository){
        this.repository = repository;
    }


    //CRUD SOBRE LIBRO

    //Buscar todos los libros
    @GetMapping("/api/libros")
    public String buscarLibros(Model model){
        //Recuperar y devolver los libros de base de datos
        model.addAttribute("libros", repository.findAll());
        return "libros";
    }

    //Form para crear libro
    @GetMapping("api/nuevoLibro")
    public String nuevoLibro(){
        return "libro-nuevo";
    }

    //Creacion de nuevo libro
    @PostMapping("api/crearLibro")
    public String registrar(@ModelAttribute LibroDto libroDto, Model model){
        model.addAttribute("libro", libroDto);


        Libro nuevoLibro = new Libro();
        nuevoLibro.setTitulo(libroDto.getTitulo());
        nuevoLibro.setAutor(libroDto.getAutor());
        nuevoLibro.setEditorial(libroDto.getEditorial());
        nuevoLibro.setGenero(libroDto.getGenero());
        nuevoLibro.setFechaDeLanzamiento(libroDto.getFechaDeLanzamiento());
        nuevoLibro.setPrecio(libroDto.getPrecio());

        System.out.println(libroDto.getFechaDeLanzamiento());

        repository.save(nuevoLibro);

        return "redirect:/api/libros";
    }


    //Buscar un libro segun su id
    @GetMapping("/api/libros/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id){
        Optional<Libro> libroOpt = repository.findById(id);

        if(libroOpt.isPresent()){
            return ResponseEntity.ok(libroOpt.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    //Crear un libro en base de datos
    @PostMapping("/api/libros")
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro nuevoLibro){
        if(nuevoLibro.getISBN() != null){
            log.warn("Error, ese libro ya existe en la base de datos");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(repository.save(nuevoLibro));
    }

    //Actualizar un libro en base de datos
    @PutMapping("/api/libros")
    public ResponseEntity<Libro> actualizarLibro(@RequestBody Libro libro){
        if(libro.getISBN() == null || !repository.existsById(libro.getISBN())){
            log.warn("Error, ese libro NO existe en la base de datos");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(repository.save(libro));
    }


    //Borrar un libro en base de datos
    @DeleteMapping("/api/libros/{id}")
    public ResponseEntity<Libro> borrarLibro(@PathVariable Long id){
        if(!repository.existsById(id)){
            log.warn("Error, ese libro NO existe en la base de datos");
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Borrar todos los libros
    @DeleteMapping("/api/libros")
    public ResponseEntity<Void> borrarLibros(){
        log.debug("Borrando todos los libros");
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
