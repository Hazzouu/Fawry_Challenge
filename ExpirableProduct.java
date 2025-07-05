import java.time.LocalDate;

public abstract class ExpirableProduct extends Product {
    protected LocalDate expirationDate;
    
    public ExpirableProduct(String name, double price, int quantity, LocalDate expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }
    
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }
    
    @Override
    public boolean isExpirable() {
        return true;
    }
    
    @Override
    public String toString() {
        return "ExpirableProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                ", isExpired=" + isExpired() +
                ", shippable=" + isShippable() +
                '}';
    }
} 