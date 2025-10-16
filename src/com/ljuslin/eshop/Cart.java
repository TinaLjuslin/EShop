package com.ljuslin.eshop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Item> items = new ArrayList<>();

    /**
     * Empty constructor
     */
    public Cart () {
    }

    /**
     * Returns all items in cart
     * @return List<Item>, all items in cart
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Adds item to cart
     * @param item, item to add
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Removes item from cart
     * @param item, item to remove
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Returns total price of cart
     * @return double, the total of the cart
     */
    public double getTotalPriceOfCart() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

}
