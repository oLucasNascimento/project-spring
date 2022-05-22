package com.project.spring.resources;

import com.project.spring.entities.Category;
import com.project.spring.entities.User;
import com.project.spring.services.CategoryService;
import com.project.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResources {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping()
    public ResponseEntity<List> findAll(){
         return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

}