package com.project.spring.services;

import com.project.spring.entities.User;
import com.project.spring.repositories.UserRepository;
import com.project.spring.services.exceptions.DataBaseException;
import com.project.spring.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    
    public User findById(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    
    public User insertUser(User user) {
        return userRepository.save(user);
    }
    
    public void deleteById(Integer id) {
        try {
            this.userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    }
    
    public User updateUser(Integer id, User user) {
        try {
            User newUser = this.userRepository.getOne(id);
            uptadeData(newUser, user);
            return this.userRepository.save(newUser);
    
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
    
    private void uptadeData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
    }
    
}