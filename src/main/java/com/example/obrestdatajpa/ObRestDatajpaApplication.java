package com.example.obrestdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		LibroRepository repository = context.getBean(LibroRepository.class);

		//Libro libro1 = new Libro("Titulo", "autor", "editorial", "genero", LocalDate.of(2000,06,06), 100);
		//Libro libro2 = new Libro("Alicia", "autor", "editorial", "genero", LocalDate.of(2000,06,06), 100);
		//Libro libro3 = new Libro("Harry Potter", "autor", "editorial", "genero", LocalDate.of(2000,06,06), 100);

		//Guardar un libro
		//repository.save(libro1);
		//repository.save(libro2);
		//repository.save(libro3);


		//Recuperar un libro
		//repository.findById(1L);
		//System.out.println("Titulo del libro: " + repository.findById(1L).get().getTitulo());

		//Eliminar un libro
		//repository.deleteById(1L);


	}

}
