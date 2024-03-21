package com.bibliotecasystem.bibsys.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bibliotecasystem.bibsys.Repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired 
    private UserRepository repository;   

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.bibliotecasystem.bibsys.Model.entities.User> o = repository.findUserByUsername(username);
        if (!o.isPresent()){
            throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema", username));
        }
        com.bibliotecasystem.bibsys.Model.entities.User user = o.orElseThrow();

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return new User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities);

    }


}
