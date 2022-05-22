package com.project.spring.services;

import com.project.spring.entities.Order;
import com.project.spring.repositories.OrderRepository;
import com.project.spring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    
    public Order findById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
    
}