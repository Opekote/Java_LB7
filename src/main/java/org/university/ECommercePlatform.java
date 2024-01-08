package org.university;

import lombok.Getter;
import org.university.comparators.ProductNameComparator;
import org.university.comparators.ProductStockComparator;
import org.university.exceptions.OutOfStockException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;


@Getter
public class ECommercePlatform {
    private final Map<Integer, User> users = new HashMap<>();
    private final Map<Integer, Product> products = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();
    private int orderIdCounter = 1;

    public void addUser(User user) {
        if (users.containsKey(user.getId())) {
            throw new IllegalArgumentException("User with this ID already exists!");
        }
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        if (products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product with this ID already exists!");
        }
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId) {
        User user = users.get(userId);
        if (user == null) {
            throw new IllegalArgumentException("No such user found!");
        }

        Map<Product, Integer> cartItems = user.getCart();

        if (!cartItems.isEmpty()) {
            Order order = Order.createOrder(orderIdCounter++, userId, cartItems);
            orders.put(order.getId(), order);

            updateProductStock(cartItems);

            user.clearCart();
        } else {
            System.out.println("Cart is empty. No order created!");
        }
    }

    private void updateProductStock(Map<Product, Integer> cartItems) {
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            int currentStock = product.getStock();
            if (currentStock >= quantity) {
                product.setStock(currentStock - quantity);
            } else {
                throw new OutOfStockException("Not enough stock for product: " + product.getName() + " !");
            }
        }
    }


    public List<Product> listAvailableProducts() {
        return products.values().stream().filter(product -> product.getStock() > 0).collect(Collectors.toList());
    }

    public List<User> listUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }


    public List<Product> listProductsSortedByName() {
        return products.values().stream().sorted(new ProductNameComparator()).collect(Collectors.toList());
    }

    public List<Product> listProductsSortedByStock() {
        return products.values().stream().sorted(new ProductStockComparator()).collect(Collectors.toList());
    }


    public List<Product> listProductsSortedByPrice() {
        return products.values().stream().filter(product -> product.getPrice() > 0).sorted().collect(Collectors.toList());
    }



}