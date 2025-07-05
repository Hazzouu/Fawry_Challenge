import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int orderCounter = 1;
    private int orderId;
    private List<CartItem> items;
    private double totalPrice;
    private LocalDateTime orderDate;
    private String status; // "Pending", "Completed", "Cancelled"
    
    public Order(List<CartItem> items) {
        this.orderId = orderCounter++;
        this.items = new ArrayList<>(items);
        this.totalPrice = calculateTotal();
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
    }
    
    private double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
    
    public int getOrderId() {
        return orderId;
    }
    
    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void completeOrder() {
        this.status = "Completed";
    }
    
    public void cancelOrder() {
        this.status = "Cancelled";
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ORDER #").append(orderId).append(" ===\n");
        sb.append("Date: ").append(orderDate).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("Items:\n");
        
        for (CartItem item : items) {
            sb.append("  - ").append(item.getProduct().getName())
              .append(" x").append(item.getQuantity())
              .append(" = $").append(String.format("%.2f", item.getTotalPrice())).append("\n");
        }
        
        sb.append("Total: $").append(String.format("%.2f", totalPrice));
        return sb.toString();
    }
} 