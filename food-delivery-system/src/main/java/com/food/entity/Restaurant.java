package com.food.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;

    public Restaurant() {}

    public Restaurant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
    return name;
    }
}