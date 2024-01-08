# E-Commerce Platform

This Java application simulates a simplified backend for an E-Commerce platform, focusing on inventory management, user shopping carts, and order processing.

## Classes

### Product

- **Fields:**
  - `id` (Integer): Product identifier.
  - `name` (String): Product name.
  - `price` (double): Product price.
  - `stock` (int): Available stock quantity.

- **Methods:**
  - `setId(Integer id)`: Set product identifier.
  - `setName(String name)`: Set product name.
  - `setPrice(double price)`: Set product price.
  - `setStock(int stock)`: Set available stock quantity.
  - `toString()`: Generate a string representation of the product.
  - `compareTo(Product other)`: Compare products based on their prices (from Comparable interface).

### User

- **Fields:**
  - `id` (Integer): User identifier.
  - `username` (String): User's username.
  - `cart` (Map<Product, Integer>): User's shopping cart.

- **Methods:**
  - `setId(Integer id)`: Set user identifier.
  - `setUsername(String username)`: Set user's username.
  - `addToCart(Product product, int quantity)`: Add products to the user's cart.
  - `removeFromCart(Product product)`: Remove products from the user's cart.
  - `updateCart(Product product, int quantity)`: Update product quantity in the user's cart.
  - `clearCart()`: Clear the user's shopping cart.
  - `toString()`: Generate a string representation of the user.

### Order

- **Fields:**
  - `id` (Integer): Order identifier.
  - `userId` (Integer): User identifier associated with the order.
  - `orderDetails` (Map<Product, Integer>): Products and their quantities in the order.
  - `totalPrice` (double): Total price of the order.

- **Methods:**
  - `calculateTotalPrice()`: Calculate the total price of the order.
  - `getTotalPrice()`: Get the total price of the order.
  - `toString()`: Generate a string representation of the order.

### ECommercePlatform

- **Fields:**
  - `users` (Map<Integer, User>): Users registered on the platform.
  - `products` (Map<Integer, Product>): Available products in the platform.
  - `orders` (Map<Integer, Order>): Processed orders on the platform.
  - `orderIdCounter` (int): Counter for order identifiers.

- **Methods:**
  - `addUser(User user)`: Add a new user to the platform.
  - `addProduct(Product product)`: Add a new product to the platform.
  - `createOrder(Integer userId)`: Create a new order for a user.
  - `listAvailableProducts()`: List available products with positive stock.
  - `listUsers()`: List all registered users on the platform.
  - `listOrders()`: List all processed orders on the platform.
  - `updateProductStock(Map<Product, Integer> cartItems)`: Update product stock after order creation.
  - `listProductsSortedByName()`: List products sorted by name.
  - `listProductsSortedByStock()`: List products sorted by stock quantity.
  - `listProductsSortedByPrice()`: List products sorted by price.

### Custom Exception

#### OutOfStockException

- **Details:**
  - This exception is thrown when there is not enough stock for a product during order creation.

- **Methods:**
  - `OutOfStockException(String errorMessage)`: Constructor to create an exception with a specific error message.
