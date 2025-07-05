import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    
    public Cart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Product product, int quantity) {
        // Check if quantity is available
        if (quantity > product.getQuantity()) {
            System.out.println("Error: Requested quantity (" + quantity + ") exceeds available quantity (" + product.getQuantity() + ") for " + product.getName());
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be greater than 0");
            return;
        }
        
        // Check if product already exists in cart
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getQuantity()) {
                    System.out.println("Error: Total quantity in cart (" + newQuantity + ") would exceed available quantity (" + product.getQuantity() + ") for " + product.getName());
                    return;
                }
                item.setQuantity(newQuantity);
                System.out.println("Updated quantity for " + product.getName() + " in cart to " + newQuantity);
                return;
            }
        }
        
        // Add new item to cart
        items.add(new CartItem(product, quantity));
        System.out.println("Added " + quantity + " " + product.getName() + " to cart");
    }
    
    public void removeItem(String productName) {
        items.removeIf(item -> item.getProduct().getName().equals(productName));
        System.out.println("Removed " + productName + " from cart");
    }
    
    public void updateQuantity(String productName, int newQuantity) {
        for (CartItem item : items) {
            if (item.getProduct().getName().equals(productName)) {
                if (newQuantity > item.getProduct().getQuantity()) {
                    System.out.println("Error: Requested quantity (" + newQuantity + ") exceeds available quantity (" + item.getProduct().getQuantity() + ") for " + productName);
                    return;
                }
                if (newQuantity <= 0) {
                    items.remove(item);
                    System.out.println("Removed " + productName + " from cart (quantity set to 0)");
                } else {
                    item.setQuantity(newQuantity);
                    System.out.println("Updated quantity for " + productName + " to " + newQuantity);
                }
                return;
            }
        }
        System.out.println("Product " + productName + " not found in cart");
    }
    
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared");
    }
    
    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
    
    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
    
    public int getItemCount() {
        return items.size();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }
        
        System.out.println("=== SHOPPING CART ===");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("Total: $" + String.format("%.2f", getTotalPrice()));
        System.out.println();
    }
} 