package org.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ECommercePlatformTest {

    private ECommercePlatform platform;
    private User user;
    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        platform = new ECommercePlatform();
        user = new User(1, "John");
        product1 = new Product(1, "Laptop", 999.99, 10);
        product2 = new Product(2, "Phone", 499.99, 20);
        product3 = new Product(3, "Tablet", 299.99, 15);

        platform.addUser(user);
        platform.addProduct(product1);
        platform.addProduct(product2);
        platform.addProduct(product3);
    }

    @Test
    void testAddUser() {
        User newUser = new User(2, "Alice");
        platform.addUser(newUser);
        assertEquals(newUser, platform.getUsers().get(2));
    }

    @Test
    void testAddProduct() {
        Product newProduct = new Product(4, "TV", 199.99, 25);
        platform.addProduct(newProduct);
        assertEquals(newProduct, platform.getProducts().get(4));
    }

    @Test
    void testCreateOrder() {
        user.addToCart(product1, 2);
        user.addToCart(product2, 1);
        platform.createOrder(user.getId());

        assertEquals(1, platform.getOrders().size());
        assertEquals(0, user.getCart().size());
        assertEquals(8, product1.getStock());
        assertEquals(19, product2.getStock());
    }

    @Test
    void testListAvailableProducts() {
        product1.setStock(0); // simulate out of stock
        assertEquals(2, platform.listAvailableProducts().size());
        assertEquals(product2, platform.listAvailableProducts().get(0));
    }

    @Test
    void testListProductsSortedByName() {

        assertEquals(product1, platform.listProductsSortedByName().get(0));
        assertEquals(product2, platform.listProductsSortedByName().get(1));
        assertEquals(product3, platform.listProductsSortedByName().get(2));
    }

    @Test
    void testListProductsSortedByPrice() {

        assertEquals(product3, platform.listProductsSortedByPrice().get(0));
        assertEquals(product2, platform.listProductsSortedByPrice().get(1));
        assertEquals(product1, platform.listProductsSortedByPrice().get(2));
    }

    @Test
    void testListProductsSortedByStock() {

        assertEquals(product2, platform.listProductsSortedByStock().get(0));
        assertEquals(product3, platform.listProductsSortedByStock().get(1));
        assertEquals(product1, platform.listProductsSortedByStock().get(2));
    }
}
