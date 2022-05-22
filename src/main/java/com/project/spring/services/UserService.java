package com.project.spring.services;

import com.project.spring.entities.User;
import com.project.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository personRepository;
    
    public List<User> findAll() {
        return personRepository.findAll();
    }
    
    public User findById(Integer id){
        Optional<User> person = personRepository.findById(id);
        return person.get();
    }
    
}