package com.bibliotecasystem.bibsys.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.bibliotecasystem.bibsys.Model.entities.Libro;

public interface LibroRepository 
        extends CrudRepository<Libro,Long>{

    
}
