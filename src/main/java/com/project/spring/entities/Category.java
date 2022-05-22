package com.project.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    
    public Category() {
    }
    
    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(getId(), category.getId());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}