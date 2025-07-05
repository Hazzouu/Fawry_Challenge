import java.time.LocalDate;

public class Biscuits extends ExpirableProduct {
    
    public Biscuits(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity, expirationDate);
    }
    
    @Override
    public boolean isShippable() {
        return false;
    }
    
    @Override
    public String toString() {
        return "Biscuits{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", isExpired=" + isExpired() +
                '}';
    }
} 