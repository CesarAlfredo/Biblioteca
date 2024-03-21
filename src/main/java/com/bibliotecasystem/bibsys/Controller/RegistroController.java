package com.bibliotecasystem.bibsys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bibliotecasystem.bibsys.Model.entities.Libro;
import com.bibliotecasystem.bibsys.Service.LibroService;

@RestController
@RequestMapping("/registro-libro")
public class RegistroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<String> createLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body("Libro creado exitosamente.");
    }

}
