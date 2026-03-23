package com.food.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {}

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters/setters
    public String getName() {
    return name;
    }
}