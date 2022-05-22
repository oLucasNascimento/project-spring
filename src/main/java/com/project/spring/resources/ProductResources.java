package com.project.spring.resources;

import com.project.spring.entities.Category;
import com.project.spring.entities.Product;
import com.project.spring.services.CategoryService;
import com.project.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResources {

    @Autowired
    private ProductService productService;
    
    @GetMapping()
    public ResponseEntity<List> findAll(){
         return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

}