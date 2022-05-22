package com.project.spring.services;

import com.project.spring.entities.Person;
import com.project.spring.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository personRepository;
    
    public List<Person> findAll() {
        return personRepository.findAll();
    }
    
    public Person findById(Integer id){
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }
    
}