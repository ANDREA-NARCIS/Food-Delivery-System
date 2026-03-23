# **🍔 Food Delivery System (Java + JPA + Hibernate + MySQL)**

## **📌 Project Overview**
The **Food Delivery System** is a console-based Java application that simulates real-world food ordering functionality.  
It is built using **JPA (Hibernate)** for ORM and **MySQL** for database persistence.

This system allows users to:
- Place food orders  
- Track order history  
- Fetch restaurant-based orders  
- Calculate total bill  

---

## **⚙️ Tech Stack**
- **Java (JDK 17)**
- **Maven**
- **JPA (Hibernate ORM)**
- **MySQL Database**
- **VS Code**

---

## **📂 Project Structure**

<img width="388" height="392" alt="image" src="https://github.com/user-attachments/assets/d4bd7405-4f84-4d5b-ad94-0c2af8c27f3f" />


## **🧩 Features Implemented**

### **1. User Management**
- Add new users  
- Store user details in database  

### **2. Restaurant Management**
- Add restaurants  
- Maintain restaurant records  

### **3. Order Management**
- Place food orders  
- Link orders with users and restaurants  

### **4. Order Tracking**
- View all orders placed by a user  

### **5. Bill Calculation**
- Calculate total bill based on user orders  

---

## **🗄️ Database Configuration**

### **Step 1: Create Database**
```sql
CREATE DATABASE food_delivery;

<img width="813" height="343" alt="image" src="https://github.com/user-attachments/assets/03845419-c1f3-4873-b8ef-b501785fcb55" />

**🚀 How to Run the Project**
1. Compile Project
mvn clean compile
2. Run Application
mvn exec:java -Dexec.mainClass="com.food.app.FoodDeliveryApp"

**🖥️ Sample Menu**

====== FOOD DELIVERY SYSTEM ======
1. Add User
2. Add Restaurant
3. Place Order
4. View User Orders
5. Calculate Total Bill
6. Exit

**🔄 JPA & Hibernate Features Used**
Entity Mapping (@Entity)
Relationships:
One-to-Many (User → Orders)
Many-to-One (Order → User, Restaurant)
Automatic Table Creation (hibernate.hbm2ddl.auto = update)
JPQL Queries

**📈 Future Enhancements**
User authentication system
Admin dashboard
REST API using Spring Boot
Web-based UI (React)
Order status tracking (Pending, Delivered)

**💡 Key Learning Outcomes**
Implemented ORM using Hibernate
Understood Entity Relationships
Built interactive console-based system
Integrated Java with MySQL database
Applied clean project structure using Maven

**📌 Author**
**Andrea Narcis**

