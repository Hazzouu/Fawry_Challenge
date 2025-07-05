public class Customer {
    private String name;
    private Cart cart;
    private double balance;
    
    public Customer(String name, double balance) {
        this.name = name;
        this.cart = new Cart();
        this.balance = balance;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Cart getCart() {
        return cart;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    // Convenience methods for cart operations
    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }
    
    public void removeFromCart(String productName) {
        cart.removeItem(productName);
    }
    
    public void updateCartQuantity(String productName, int newQuantity) {
        cart.updateQuantity(productName, newQuantity);
    }
    
    public void displayCart() {
        System.out.println("=== " + name + "'s CART ===");
        cart.displayCart();
    }
    
    public void clearCart() {
        cart.clearCart();
    }
    
    // Calculate shipping fees based on shippable items
    private double calculateShippingFees() {
        double shippingFees = 0;
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.isShippable()) {
                // Calculate shipping based on weight and quantity
                double weight = 0;
                if (product instanceof Cheese) {
                    weight = ((Cheese) product).getWeight();
                } else if (product instanceof TV) {
                    weight = ((TV) product).getWeight();
                } else if (product instanceof Mobile) {
                    weight = ((Mobile) product).getWeight();
                }
                shippingFees += weight * item.getQuantity() * 2.0; // $2 per kg
            }
        }
        return shippingFees;
    }
    
    // Check if any products are expired or out of stock
    private String validateCart() {
        if (cart.isEmpty()) {
            return "Error: Cart is empty";
        }
        
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            
            // Check if product is expired
            if (product.isExpirable()) {
                ExpirableProduct expirableProduct = (ExpirableProduct) product;
                if (expirableProduct.isExpired()) {
                    return "Error: " + product.getName() + " is expired";
                }
            }
            
            // Check if product is out of stock
            if (item.getQuantity() > product.getQuantity()) {
                return "Error: " + product.getName() + " is out of stock (requested: " + 
                       item.getQuantity() + ", available: " + product.getQuantity() + ")";
            }
        }
        
        return null; // No errors
    }
    
    public boolean checkout() {
        // Validate cart
        String error = validateCart();
        if (error != null) {
            System.out.println(error);
            return false;
        }
        
        // Calculate costs
        double subtotal = cart.getTotalPrice();
        double shippingFees = calculateShippingFees();
        double totalAmount = subtotal + shippingFees;
        
        // Check if customer has sufficient balance
        if (totalAmount > balance) {
            System.out.println("Error: Insufficient balance. Required: $" + 
                             String.format("%.2f", totalAmount) + 
                             ", Available: $" + String.format("%.2f", balance));
            return false;
        }
        
        // Update product quantities after checkout
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            product.setQuantity(product.getQuantity() - item.getQuantity());
        }
        
        // Deduct amount from customer balance
        balance -= totalAmount;
        
        // Print checkout details
        System.out.println("=== CHECKOUT DETAILS FOR " + name.toUpperCase() + " ===");
        System.out.println("Subtotal: $" + String.format("%.2f", subtotal));
        System.out.println("Shipping Fees: $" + String.format("%.2f", shippingFees));
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
        System.out.println("Previous Balance: $" + String.format("%.2f", balance + totalAmount));
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("=====================================");
        
        // Clear cart after checkout
        cart.clearCart();
        
        return true;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", balance=$" + String.format("%.2f", balance) +
                ", cartItems=" + cart.getItemCount() +
                '}';
    }
} 