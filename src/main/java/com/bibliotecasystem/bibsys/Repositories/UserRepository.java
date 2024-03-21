package com.bibliotecasystem.bibsys.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bibliotecasystem.bibsys.Model.entities.User;

public interface UserRepository 
        extends CrudRepository<User,Long>{

        Optional<User> findUserByUsername(String username);
    
}
