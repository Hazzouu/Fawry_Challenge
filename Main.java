import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create sample products
        LocalDate futureDate = LocalDate.now().plusDays(30);
        LocalDate pastDate = LocalDate.now().minusDays(5);
        
        // Expirable and Shippable: Cheese
        Cheese cheese = new Cheese("Cheddar Cheese", 15.99, 50, futureDate, 0.5);
        
        // Expirable and Non-Shippable: Biscuits
        Biscuits biscuits = new Biscuits("Chocolate Biscuits", 3.99, 100, futureDate);
        
        // Non-Expirable and Shippable: TV
        TV tv = new TV("Samsung 55\" TV", 899.99, 10, 25.0);
        
        // Non-Expirable and Shippable: Mobile
        Mobile mobile = new Mobile("iPhone 15", 999.99, 25, 0.2);
        
        // Non-Expirable and Non-Shippable: Mobile Scratch Card
        MobileScratchCard scratchCard = new MobileScratchCard("Vodafone 50GB Card", 19.99, 200);
        
        // Expired product for testing
        Cheese expiredCheese = new Cheese("Expired Cheese", 10.99, 5, pastDate, 0.3);
        
        // Display all products
        System.out.println("=== AVAILABLE PRODUCTS ===");
        System.out.println(cheese);
        System.out.println(biscuits);
        System.out.println(tv);
        System.out.println(mobile);
        System.out.println(scratchCard);
        System.out.println(expiredCheese);
        System.out.println();
        
        // Create customers with different balances
        Customer yousef = new Customer("Yousef", 2000.0);
        Customer sarah = new Customer("Sarah", 500.0);
        Customer hasan = new Customer("Hasan", 50.0); // Low balance for testing
        
        System.out.println("=== CUSTOMER 1: YOUSEF (Balance: $2000) ===");
        
        // Yousef adds items to his cart
        yousef.addToCart(cheese, 2);
        yousef.addToCart(biscuits, 5);
        yousef.addToCart(mobile, 1);
        
        // Display Yousef's cart
        yousef.displayCart();
        
        // Yousef checks out
        System.out.println("YOUSEF'S CHECKOUT");
        boolean yousefCheckout = yousef.checkout();
        if (yousefCheckout) {
            System.out.println("Yousef's checkout was successful!");
        }
        
        // Display updated product quantities
        System.out.println("=== UPDATED PRODUCT QUANTITIES ===");
        System.out.println(cheese);
        System.out.println(biscuits);
        System.out.println(tv);
        System.out.println(mobile);
        System.out.println(scratchCard);
        System.out.println();
        
        System.out.println("=== CUSTOMER 2: SARAH (Balance: $500) ===");
        
        // Sarah adds items to her cart
        sarah.addToCart(tv, 1); // Expensive item
        sarah.addToCart(scratchCard, 3);
        
        // Display Sarah's cart
        sarah.displayCart();
        
        // Sarah checks out
        System.out.println("=== SARAH'S CHECKOUT ===");
        boolean sarahCheckout = sarah.checkout();
        if (sarahCheckout) {
            System.out.println("Sarah's checkout was successful!");
        }
        
        System.out.println("=== CUSTOMER 3: HASAN (Balance: $50) - TESTING ERRORS ===");
        
        // Test 1: Try to checkout with empty cart
        System.out.println("--- Testing Empty Cart ---");
        hasan.checkout();
        
        // Test 2: Try to add expired product
        System.out.println("--- Testing Expired Product ---");
        hasan.addToCart(expiredCheese, 1);
        hasan.displayCart();
        hasan.checkout();
        hasan.clearCart();
        
        // Test 3: Try to add more than available quantity
        System.out.println("--- Testing Out of Stock ---");
        hasan.addToCart(tv, 15); // Only 8 available now (after Sarah's purchase)
        hasan.displayCart();
        hasan.checkout();
        hasan.clearCart();
        
        // Test 4: Try to checkout with insufficient balance
        System.out.println("--- Testing Insufficient Balance ---");
        hasan.addToCart(mobile, 1); // $999.99 + shipping
        hasan.displayCart();
        hasan.checkout();
        
        // Test 5: Successful checkout with small items
        System.out.println("--- Testing Successful Checkout ---");
        hasan.addToCart(scratchCard, 2);
        hasan.addToCart(biscuits, 1);
        hasan.displayCart();
        hasan.checkout();
        
        // Final product quantities
        System.out.println("=== FINAL PRODUCT QUANTITIES ===");
        System.out.println(cheese);
        System.out.println(biscuits);
        System.out.println(tv);
        System.out.println(mobile);
        System.out.println(scratchCard);
        
        // Show customer information
        System.out.println("=== CUSTOMER INFORMATION ===");
        System.out.println(yousef);
        System.out.println(sarah);
        System.out.println(hasan);
    }
} 