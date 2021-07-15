package hotel;

import java.io.Serializable;
import java.util.ArrayList;


public class Room implements Serializable{
    
    private String name;
    private String contact;
    private String gender;
    private double price;
    private int nigths;
    private ArrayList<Food> foodList = new ArrayList();

    
    public Room(String name, String contact, String gender, double price, int nigths) {
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.price = price;
        this.nigths = nigths;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return the nigths
     */
    public int getNigths() {
        return nigths;
    }

    /**
     * @param nigths the nigths to set
     */
    public void setNigths(int nigths) {
        this.nigths = nigths;
    }

    /**
     * @return the foodList
     */
    public ArrayList<Food> getFoodList() {
        return foodList;
    }

    /**
     * @param foodList the foodList to set
     */
    public void addFood(Food food) {
        this.foodList.add(food);
    }
    
    
        
    
}
