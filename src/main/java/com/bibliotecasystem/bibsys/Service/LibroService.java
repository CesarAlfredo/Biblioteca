package com.bibliotecasystem.bibsys.Service;

import java.util.List;
import java.util.Optional;

import com.bibliotecasystem.bibsys.Model.entities.Libro;

public interface LibroService {

        //encontrar todos
        List<Libro> findAll();
        // encontrar por id
        Optional<Libro> findById(Long id);
        //guardar
        Libro save (Libro user);
         //ACTUALIZAR
         Optional<Libro> update (Libro user, Long id);
        //eliminar
        void remove (Long id);
    
} 
