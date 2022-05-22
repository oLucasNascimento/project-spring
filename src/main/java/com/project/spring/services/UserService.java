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
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    public User findById(Integer id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
    
    public User insertUser(User user) {
        return userRepository.save(user);
    }
    
}