package com.project.spring.services;

import com.project.spring.entities.Category;
import com.project.spring.entities.Product;
import com.project.spring.repositories.CategoryRepository;
import com.project.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    
    public Product findById(Integer id){
        Optional<Product> user = productRepository.findById(id);
        return user.get();
    }
    
}