package com.project.spring.services;

import com.project.spring.entities.Category;
import com.project.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    
    public Category findById(Integer id){
        Optional<Category> user = categoryRepository.findById(id);
        return user.get();
    }
    
}