package hotel;

import java.io.Serializable;


public class Food implements Serializable {
    
    private String type;
    private double price;
    private int quantity;

    
    public Food(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    
    
    
}
