package com.bibliotecasystem.bibsys.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bibliotecasystem.bibsys.Model.entities.Role;

public interface RoleRepository 
        extends CrudRepository<Role,Long>{
        
        Optional<Role> findByName(String name);
    
} 
