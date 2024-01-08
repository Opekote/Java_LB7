package org.university;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Order {
    private final Integer id;
    private final Integer userId;
    private final Map<Product, Integer> orderDetails = new HashMap<>();
    private double totalPrice;

    private Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails.putAll(orderDetails);
        calculateTotalPrice();
    }

    public static Order createOrder(Integer id, Integer userId, Map<Product, Integer> orderDetails){
        if (orderDetails == null || orderDetails.isEmpty()) {
            throw new IllegalArgumentException("Order details cannot be null or empty!");
        }

        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("Product in order details cannot be null!");
            }

            if (entry.getValue() <= 0) {
                throw new IllegalArgumentException("Product quantity in order details must be greater than zero!");
            }
        }

        return new Order(id,userId,orderDetails);
    }
    private void calculateTotalPrice() {
        totalPrice = 0;
        for(Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            totalPrice += entry.getKey().getPrice() * entry.getValue();
        }
    }



    public double getTotalPrice() {
        calculateTotalPrice();
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderDetails=" + orderDetails +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
