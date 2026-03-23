package com.food.service;

import com.food.entity.Order;
import com.food.util.JPAUtil;

import jakarta.persistence.EntityManager;

import java.util.List;

public class OrderService {

    public void placeOrder(Order order) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(order);

        em.getTransaction().commit();
        em.close();
    }

    public List<Order> getOrdersByUser(int userId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Order> orders = em.createQuery(
                "SELECT o FROM Order o WHERE o.user.id = :uid", Order.class)
                .setParameter("uid", userId)
                .getResultList();

        em.close();
        return orders;
    }

    public double calculateBill(int userId) {
        EntityManager em = JPAUtil.getEntityManager();

        Double total = em.createQuery(
                "SELECT SUM(o.price) FROM Order o WHERE o.user.id = :uid", Double.class)
                .setParameter("uid", userId)
                .getSingleResult();

        em.close();
        return total != null ? total : 0;
    }
}