package com.ljuslin.eshop;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();
    private double totalPrice;
    private Status status;
    private Customer customer;
    public Order(List<Item> items, Customer customer, double totalPrice, Status status) {
        this.items = items;
        this.customer = customer;
        this.totalPrice = totalPrice;
        this.status = Status.CREATED;
    }

    /**
     * Returns items
     * @return List<Item> list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Sets new item list
     * @param items, list of items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Returns customer
     * @return Customer, the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets new customer
     * @param customer, the new customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Returns total prica
     * @return double, total price
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Sets total price
     * @param totalPrice, total price
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Returns status of order
     * @return Status, status of order
     */
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
