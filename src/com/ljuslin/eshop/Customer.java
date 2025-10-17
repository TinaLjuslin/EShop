package com.ljuslin.eshop;

import com.ljuslin.util.People;

import java.util.ArrayList;
import java.util.List;

public class Customer extends People {
    private String username;
    private String password;
    private static int counter = 100;
    private Cart cart = new Cart();
    /**
     * Empty constructor
     */
    public Customer() {
    }

    /**
     * Constructor, sets values
     * @param firstName, the first name
     * @param lastName the last name
     * @param password the password
     */
    public Customer(String firstName, String lastName, String password) {
        super(firstName, lastName);
        this.username = "CU-" + String.valueOf(counter++);
        this.password = password;
    }
    public String getName() {
        return (getFirstName() + " " + getLastName());
    }
    /**
     * Returns username
     * @return String, the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     * @param username, the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns customers pasword
     * @return String customers password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set customers password
     * @param password, the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public void emptyCart() {
        this.cart = new Cart();
    }
    public void addToCart(Item item) {
        cart.addItem(item);
    }

    /**
     * Overrides toString()
     * @return
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", username: " + username + ", password: "
                + password;
    }
}