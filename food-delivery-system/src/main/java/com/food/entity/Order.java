package com.food.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders") // 'order' is reserved keyword
public class Order {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private String foodItem;
    private double price;

    public Order() {}

    public Order(int id, User user, Restaurant restaurant, String foodItem, double price) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.foodItem = foodItem;
        this.price = price;
    }

    public int getId() {
    return id;
    }

    public String getFoodItem() {
    return foodItem;
    }

    public double getPrice() {
    return price;
    }
}