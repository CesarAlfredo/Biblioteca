package com.bibliotecasystem.bibsys.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecasystem.bibsys.Model.entities.Localizacion;
import com.bibliotecasystem.bibsys.Service.LocalizacionService;

@RestController
@RequestMapping("/localizaciones")
public class LocalizacionController {

    @Autowired
    private LocalizacionService localizacionService;

    @GetMapping
    public ResponseEntity<List<Localizacion>> getAllLocalizaciones() {
        List<Localizacion> localizaciones = localizacionService.findAll();
        return ResponseEntity.ok(localizaciones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacion> getLocalizacionById(@PathVariable("id") Long id) {
        Optional<Localizacion> localizacion = localizacionService.findById(id);
        return localizacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Localizacion> createLocalizacion(@RequestBody Localizacion localizacion) {
        Localizacion createdLocalizacion = localizacionService.save(localizacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLocalizacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Localizacion> updateLocalizacion(@PathVariable("id") Long id, @RequestBody Localizacion localizacion) {
        Optional<Localizacion> updatedLocalizacion = localizacionService.update(localizacion, id);
        return updatedLocalizacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocalizacion(@PathVariable("id") Long id) {
        localizacionService.remove(id);
        return ResponseEntity.noContent().build();
    }
}