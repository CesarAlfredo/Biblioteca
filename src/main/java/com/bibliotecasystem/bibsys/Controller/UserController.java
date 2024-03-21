package com.bibliotecasystem.bibsys.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecasystem.bibsys.Model.entities.User;
import com.bibliotecasystem.bibsys.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list(){
        return service.findAll();
    }
    
    @PostMapping
    public ResponseEntity <?> create (@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return validation(result);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    private ResponseEntity<?> validation(BindingResult result) {
    Map <String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach( err -> {
        errors.put(err.getField(),"La seccion:" + err.getField() + " " + err.getDefaultMessage());

        });
       return ResponseEntity.badRequest().body(errors);
    }

    
}
