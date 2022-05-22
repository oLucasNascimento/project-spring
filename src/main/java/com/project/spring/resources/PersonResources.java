package com.project.spring.resources;

import com.project.spring.entities.Person;
import com.project.spring.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonResources {

    @Autowired
    private PersonService personService;
    
    @GetMapping()
    public ResponseEntity<List> findAll(){
         return ResponseEntity.ok().body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(personService.findById(id));
    }

}