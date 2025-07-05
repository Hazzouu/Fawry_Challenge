public abstract class NonShippableProduct extends Product {
    
    public NonShippableProduct(String name, double price, int quantity) {
        super(name, price, quantity);
    }
    
    @Override
    public boolean isShippable() {
        return false;
    }
    
    @Override
    public String toString() {
        return "NonShippableProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", expirable=" + isExpirable() +
                '}';
    }
} 