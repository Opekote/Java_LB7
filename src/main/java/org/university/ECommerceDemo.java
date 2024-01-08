package org.university;

import java.util.List;

public class ECommerceDemo {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        User user1 = new User(1, "John");
        User user2 = new User(2, "Alice");
        platform.addUser(user1);
        platform.addUser(user2);

        Product product1 = new Product(1, "Laptop", 999.99, 10);
        Product product2 = new Product(2, "Phone", 499.99, 20);
        platform.addProduct(product1);
        platform.addProduct(product2);

        user1.addToCart(product1, 2);
        user2.addToCart(product2, 1);
        user1.addToCart(product2, 3);

        List<Product> availableProducts = platform.listAvailableProducts();
        System.out.println("Available Products:");
        for (Product product : availableProducts) {
            System.out.println(product);
        }

        platform.createOrder(user1.getId());
        platform.createOrder(user2.getId());

        System.out.println("Products sorted by price");
        for (Product product : platform.listProductsSortedByPrice()){
            System.out.println(product);
        }

        System.out.println("Products sorted by stock");
        for (Product product : platform.listProductsSortedByStock()){
            System.out.println(product);
        }

        System.out.println("Final State:");
        System.out.println("Users:");
        for (User user : platform.listUsers()) {
            System.out.println(user);
        }

        System.out.println("Products:");
        for (Product product : platform.listProductsSortedByName()) {
            System.out.println(product);
        }

        System.out.println("Orders:");
        for (Order order : platform.listOrders()) {
            System.out.println(order);
        }

        System.out.println("Orders price:");
        for (Order order : platform.listOrders()) {
            System.out.println("Order id: " + order.getId() + ". Total price: " + order.getTotalPrice());
        }


    }
}
