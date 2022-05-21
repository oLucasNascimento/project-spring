package com.project.spring.resources;

import com.project.spring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {
    
    @GetMapping()
    public ResponseEntity<User> findAll(){
        
        User user = new User(1,"Maria", "maria@gmail.com", "94770038", "0311");
        return ResponseEntity.ok(user);
    }
    
    
}