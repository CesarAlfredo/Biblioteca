package com.bibliotecasystem.bibsys.Service;

import java.util.List;
import java.util.Optional;

import com.bibliotecasystem.bibsys.Model.entities.User;

public interface UserService {

        //encontrar todos
        List<User> findAll();
        //guardar
        User save (User user);
         //ACTUALIZAR
    
} 
