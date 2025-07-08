# E-Commerce System

A simple Java-based e-commerce system that demonstrates object-oriented programming concepts with different types of products, shopping cart functionality, and checkout process.

## Features

- **Product Management**: Define products with name, price, and quantity
- **Expiration Support**: Some products can expire (like food items)
- **Shipping Support**: Some products require shipping and have weight information
- **Flexible Product Types**: Support for various product combinations
- **Customer Management**: Each customer has their own cart and balance
- **Shopping Cart**: Add products to cart with quantity validation
- **Detailed Checkout**: Complete orders with subtotal, shipping fees, and balance tracking
- **Error Handling**: Comprehensive validation for cart and checkout process

## Class Structure

```
Product (abstract)
├── ExpirableProduct (abstract)
│   ├── Cheese (expirable + shippable)
│   └── Biscuits (expirable + non-shippable)
└── NonExpirableProduct (abstract)
    ├── TV (non-expirable + shippable)
    ├── Mobile (non-expirable + shippable)
    └── MobileScratchCard (non-expirable + non-shippable)

Customer Management:
├── Customer (has name, balance, and personal cart)

Cart Management:
├── Cart (manages shopping cart)
└── CartItem (represents items in cart)

Main (demonstrates the system)
```

## Product Types

### Expirable Products
- **Cheese**: Expires, requires shipping, has weight
- **Biscuits**: Expires, doesn't require shipping

### Non-Expirable Products
- **TV**: Doesn't expire, requires shipping, has weight
- **Mobile**: Doesn't expire, requires shipping, has weight
- **Mobile Scratch Card**: Doesn't expire, doesn't require shipping

## Customer Functionality

### Customer Management
- Each customer has a unique name and balance
- Each customer has their own personal cart
- Customers can manage their cart independently
- Balance is tracked and updated after purchases

### Customer Cart Operations
- **Add to Cart**: Add products with quantity validation
- **Update Quantities**: Modify quantities in cart
- **Remove Items**: Remove specific items from cart
- **View Cart**: Display cart contents and total
- **Checkout**: Complete orders with detailed pricing

## Checkout Process

### Detailed Checkout Information
The system provides comprehensive checkout details including:
- **Order Subtotal**: Sum of all items' prices
- **Shipping Fees**: Calculated based on weight of shippable items ($2 per kg)
- **Total Amount**: Subtotal + shipping fees
- **Previous Balance**: Customer's balance before purchase
- **Current Balance**: Customer's balance after purchase

### Error Handling
The system validates the following conditions and provides appropriate error messages:
- **Empty Cart**: Cannot checkout with empty cart
- **Insufficient Balance**: Customer doesn't have enough money
- **Expired Products**: Products that have passed their expiration date
- **Out of Stock**: Requested quantity exceeds available stock

## Cart Functionality

### Adding to Cart
- Customers can add products to cart with specific quantities
- System validates that requested quantity doesn't exceed available stock
- If product already exists in cart, quantities are combined
- Error messages for invalid quantities

### Cart Management
- View cart contents with total price
- Update quantities of items in cart
- Remove items from cart
- Clear entire cart

## How to Run

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the main class:
   ```bash
   java Main
   ```

## System Capabilities

The system provides the following functionality:

### Product Management
- **Product Types**: Different product categories with inheritance
- **Expiration Support**: Automatic expiration checking for food items
- **Shipping Support**: Weight tracking for shippable items
- **Inventory Management**: Quantity tracking and updates

### Customer Management
- **Individual Carts**: Each customer has their own cart
- **Balance Tracking**: Each customer has a personal balance
- **Personalized Operations**: Customers can manage their own shopping experience
- **Independent Checkout**: Each customer can checkout separately

### Cart Management
- **Add to Cart**: Add products with quantity validation
- **Update Quantities**: Modify quantities in cart
- **Remove Items**: Remove specific items from cart
- **View Cart**: Display cart contents and total

### Checkout Management
- **Direct Checkout**: Process checkout without creating order objects
- **Inventory Updates**: Automatic quantity reduction after checkout
- **Detailed Pricing**: Subtotal, shipping fees, and total amount
- **Balance Updates**: Automatic balance deduction after successful checkout

## Example Output

When you run the system, it will demonstrate:
- All available products with their details
- Multiple customers with different balances
- Adding items to customer carts with quantity validation
- Cart management (updating, removing items)
- Individual checkout processes for each customer with detailed pricing
- Error handling for various scenarios (empty cart, insufficient balance, expired products, out of stock)
- Inventory updates after each checkout
- Balance tracking for each customer

## Key Features Demonstrated

1. **Inheritance**: Product hierarchy with abstract classes
2. **Polymorphism**: Different product types with common interface
3. **Encapsulation**: Private fields with public getters/setters
4. **Data Validation**: Comprehensive error checking and validation
5. **State Management**: Individual customer carts, balances, and checkout tracking
6. **Business Logic**: Inventory management, shipping calculations, and checkout processing
7. **Object Composition**: Customer has-a Cart relationship
8. **Error Handling**: Robust validation for real-world scenarios

This system demonstrates comprehensive object-oriented programming concepts while providing a practical e-commerce solution with customer management, detailed checkout functionality, and robust error handling. 

![image](https://github.com/user-attachments/assets/a71dc4d8-d99a-4e00-899b-3041e5404b34)

![image](https://github.com/user-attachments/assets/9e77551b-1841-4eef-b307-8047721ed521)

![image](https://github.com/user-attachments/assets/4a25fe06-e6f2-4410-ba64-ab2ed7b0d61d)
![image](https://github.com/user-attachments/assets/84401f75-f128-4fa6-afb9-638dbfad92fd)
![image](https://github.com/user-attachments/assets/2c969fb4-8756-4fca-82f1-c9671edb4731)


