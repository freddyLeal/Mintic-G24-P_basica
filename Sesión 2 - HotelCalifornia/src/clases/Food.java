package clases;


public class Food {
    private String type;
    private int quantity;
    private double price;

    
    public Food(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
    
    
    
    
    
}
