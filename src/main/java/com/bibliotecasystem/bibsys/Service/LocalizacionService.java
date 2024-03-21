package com.bibliotecasystem.bibsys.Service;

import java.util.List;
import java.util.Optional;

import com.bibliotecasystem.bibsys.Model.entities.Localizacion;

public interface LocalizacionService {

            //encontrar todos
        List<Localizacion> findAll();
        // encontrar por id
        Optional<Localizacion> findById(Long id);
        //guardar
        Localizacion save (Localizacion user);
         //ACTUALIZAR
         Optional<Localizacion> update (Localizacion user, Long id);
        //eliminar
        void remove (Long id);

    
} 
