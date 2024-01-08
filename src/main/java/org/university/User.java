package org.university;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class User {
    private Integer id;
    private String username;
    private final Map<Product, Integer> cart = new HashMap<>();

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public void setId(Integer id) { this.id = id; }


    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username can't be null or empty!");
        }
        this.username = username;
    }

    public void addToCart(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity of product!");
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }


    public void removeFromCart(Product product) {
        if (!cart.containsKey(product)) {
            throw new IllegalArgumentException("No a such product found in cart!");
        }
        cart.remove(product);
    }


    public void updateCart(Product product, int quantity) {
        if(cart.containsKey(product)) {
            cart.put(product, quantity);
        }
    }

    public void clearCart() {
        cart.clear();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", cart=" + cart +
                '}';
    }
}