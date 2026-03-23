package com.food;

import com.food.entity.*;
import com.food.service.OrderService;
import com.food.util.JPAUtil;

import jakarta.persistence.EntityManager;

import java.util.Scanner;
import java.util.List;

public class FoodDeliveryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderService service = new OrderService();

        while (true) {
            System.out.println("\n====== FOOD DELIVERY SYSTEM ======");
            System.out.println("1. Add User");
            System.out.println("2. Add Restaurant");
            System.out.println("3. Place Order");
            System.out.println("4. View User Orders");
            System.out.println("5. Calculate Total Bill");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ✅ Add User
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter User Name: ");
                    String uname = sc.nextLine();

                    EntityManager em1 = JPAUtil.getEntityManager();
                    em1.getTransaction().begin();

                    User user = new User(uid, uname);
                    em1.persist(user);

                    em1.getTransaction().commit();
                    em1.close();

                    System.out.println("✅ User added successfully!");
                    break;

                // ✅ Add Restaurant
                case 2:
                    System.out.print("Enter Restaurant ID: ");
                    int rid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Restaurant Name: ");
                    String rname = sc.nextLine();

                    EntityManager em2 = JPAUtil.getEntityManager();
                    em2.getTransaction().begin();

                    Restaurant restaurant = new Restaurant(rid, rname);
                    em2.persist(restaurant);

                    em2.getTransaction().commit();
                    em2.close();

                    System.out.println("✅ Restaurant added successfully!");
                    break;

                // ✅ Place Order
                case 3:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();

                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();

                    System.out.print("Enter Restaurant ID: ");
                    int restId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Food Item: ");
                    String food = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    EntityManager em3 = JPAUtil.getEntityManager();
                    em3.getTransaction().begin();

                    User u = em3.find(User.class, userId);
                    Restaurant r = em3.find(Restaurant.class, restId);

                    if (u == null || r == null) {
                        System.out.println("❌ Invalid User or Restaurant ID");
                        em3.close();
                        break;
                    }

                    Order order = new Order(oid, u, r, food, price);
                    em3.persist(order);

                    em3.getTransaction().commit();
                    em3.close();

                    System.out.println("✅ Order placed successfully!");
                    break;

                // ✅ View Orders by User
                case 4:
                    System.out.print("Enter User ID: ");
                    int viewId = sc.nextInt();

                    List<Order> orders = service.getOrdersByUser(viewId);

                    if (orders.isEmpty()) {
                        System.out.println("No orders found.");
                    } else {
                        for (Order o : orders) {
                            System.out.println("Order ID: " + o.getId() +
                                    ", Food: " + o.getFoodItem() +
                                    ", Price: " + o.getPrice());
                        }
                    }
                    break;

                // ✅ Calculate Bill
                case 5:
                    System.out.print("Enter User ID: ");
                    int billId = sc.nextInt();

                    double total = service.calculateBill(billId);
                    System.out.println("💰 Total Bill: " + total);
                    break;

                // ✅ Exit
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}