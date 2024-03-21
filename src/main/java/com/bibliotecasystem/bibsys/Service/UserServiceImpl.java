package com.bibliotecasystem.bibsys.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bibliotecasystem.bibsys.Model.entities.Role;
import com.bibliotecasystem.bibsys.Model.entities.User;
import com.bibliotecasystem.bibsys.Repositories.RoleRepository;
import com.bibliotecasystem.bibsys.Repositories.UserRepository;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl
        implements UserService {

            
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        
        return (List<User>) repository.findAll();
    }


    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Optional<Role> o = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        if (o.isPresent()){
            roles.add(o.orElseThrow());
        } 
        
        user.setRoles(roles);

        return repository.save(user);
    }
    
}
