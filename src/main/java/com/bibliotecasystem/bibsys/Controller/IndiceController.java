package com.bibliotecasystem.bibsys.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecasystem.bibsys.Model.entities.Libro;
import com.bibliotecasystem.bibsys.Service.LibroService;

@RestController
@RequestMapping("/indice")
public class IndiceController {

    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = libroService.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getLibroDetails(@PathVariable("id") Long id) {
        Optional<Libro> libro = libroService.findById(id);
        if (libro.isPresent()) {
            String detalles = "Título: " + libro.get().getTitulo() + "\n" +
                              "Volumen: " + libro.get().getVolumen() + "\n" +
                              "Aula: " + libro.get().getLocalizacion().getAula() + "\n" +
                              "Librero: " + libro.get().getLocalizacion().getLibrero();
            return ResponseEntity.ok(detalles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
