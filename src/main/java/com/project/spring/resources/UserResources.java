package com.project.spring.resources;

import com.project.spring.entities.User;
import com.project.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResources {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody User user){
        user = userService.insertUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    
    @GetMapping()
    public ResponseEntity<List<User>> findAll(){
         return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(userService.findById(id));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}