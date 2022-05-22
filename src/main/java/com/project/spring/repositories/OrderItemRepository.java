package com.project.spring.repositories;

import com.project.spring.entities.OrderItem;
import com.project.spring.entities.User;
import com.project.spring.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}