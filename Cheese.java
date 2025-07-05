import java.time.LocalDate;

public class Cheese extends ExpirableProduct {
    private double weight; // in kg
    
    public Cheese(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    @Override
    public boolean isShippable() {
        return true;
    }
    
    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", weight=" + weight + "kg" +
                ", expirable=" + isExpirable() +
                '}';
    }
} 