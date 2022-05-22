package com.project.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.spring.entities.pk.OrderItemPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    
    private Integer quantity;
    private Double price;
    
    public OrderItem() {
    }
    
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    @JsonIgnore
    public Order getOrder() {
        return this.id.getOrder();
    }
    
    public void setOrder(Order order) {
        this.id.setOrder(order);
    }
    
    public Product getProduct() {
        return this.id.getProduct();
    }
    
    public void setProduct(Product product) {
        this.id.setProduct(product);
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}