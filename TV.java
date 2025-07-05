public class TV extends NonExpirableProduct {
    private double weight; 
    
    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
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
        return "TV{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", weight=" + weight + "kg" +
                '}';
    }
} 