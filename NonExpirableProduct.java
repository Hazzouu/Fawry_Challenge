public abstract class NonExpirableProduct extends Product {
    
    public NonExpirableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    
    @Override
    public boolean isExpirable() {
        return false;
    }
    
    @Override
    public String toString() {
        return "NonExpirableProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", shippable=" + isShippable() +
                '}';
    }
} 