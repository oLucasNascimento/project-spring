package com.project.spring.repositories;

import com.project.spring.entities.Category;
import com.project.spring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}