package com.bibliotecasystem.bibsys.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecasystem.bibsys.Model.entities.Libro;
import com.bibliotecasystem.bibsys.Model.entities.Localizacion;
import com.bibliotecasystem.bibsys.Repositories.LibroRepository;


@Service
public class LibroServiceImpl implements LibroService{

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LocalizacionService localizacionService;

    @Override
    @Transactional(readOnly = true)
    public List<Libro> findAll() {
        return (List<Libro>) libroRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    @Transactional
    public Libro save(Libro libro) {

        if (libro.getLocalizacion() != null) {
            // Guardar la localización si no tiene ID
            if (libro.getLocalizacion().getId() == null) {
                Localizacion savedLocalizacion = localizacionService.save(libro.getLocalizacion());
                libro.setLocalizacion(savedLocalizacion);
            }
        }
        return libroRepository.save(libro);
    }

    @Override
    @Transactional
    public Optional<Libro> update(Libro libro, Long id) {
        Optional<Libro> existingLibro = libroRepository.findById(id);
        if (existingLibro.isPresent()) {
            // Actualizar campos del libro
            Libro updatedLibro = existingLibro.get();
            updatedLibro.setTitulo(libro.getTitulo());
            updatedLibro.setVolumen(libro.getVolumen());
            updatedLibro.setLocalizacion(libro.getLocalizacion());
            return Optional.of(libroRepository.save(updatedLibro));
        } else {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public void remove(Long id) {
        libroRepository.deleteById(id);
    }
}
