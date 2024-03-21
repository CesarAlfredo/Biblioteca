package com.bibliotecasystem.bibsys.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.bibliotecasystem.bibsys.Model.entities.Localizacion;

public interface LocalizacionRepository
        extends CrudRepository<Localizacion,Long> {

    
}
