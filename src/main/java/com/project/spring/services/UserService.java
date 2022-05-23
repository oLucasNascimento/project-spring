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
        return this.userRepository.findAll();
    }
    
    public User findById(Integer id){
        Optional<User> user = this.userRepository.findById(id);
        return user.get();
    }
    
    public User insertUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteById(Integer id){
        this.userRepository.deleteById(id);
    }
    
    public User updateUser(Integer id, User user) {
        User newUser = this.userRepository.getOne(id);
        uptadeData(newUser, user);
        return this.userRepository.save(newUser);
    }
    
    private void uptadeData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
    }
    
}