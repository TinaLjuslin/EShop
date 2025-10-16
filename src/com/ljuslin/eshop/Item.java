package com.ljuslin.eshop;

public class Item {
    static int counter = 100;
    private String id;
    private String name;
    private String description;
    private double price;
    private int quantity = 0;

    /**
     * Empty constructor
     */
    public Item() {

    }

    /**
     * Constructor, creates new item with unique id
     * @param name, name of item
     * @param description, description of item
     * @param price, price of item
     */
    public Item(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.id = "Item" + counter++;
    }

    /**
     * Returns id of item
     * @return, the id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns name of item
     * @return String, the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name
     * @param name, new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns description of item
     * @return String, description of item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description of item
     * @param description new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns items price
     * @return String, the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets new price of item
     * @param price, new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns quantity of item
     * @return int, the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Adds to quantity
     * @param quantity quantity to add
     */
    public void addToQuantity(int quantity) {
        this.quantity += quantity;
    }

    /**
     * Retracts from quantity
     * @param quantity, quantity to retract
     */
    public void retractFromQuantity(int quantity) {
        this.quantity -= quantity;
    }

    /**
     * Overrides toString()
     * @return String, new string
     */
    @Override
    public String toString() {
        return name + ": " + description + ". Price: " + price;
    }
}
