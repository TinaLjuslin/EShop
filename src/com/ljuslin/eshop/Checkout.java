package com.ljuslin.eshop;

import com.ljuslin.userinteraction.UserInteraction;

public class Checkout {
    private final double TAX = 12.0;
    private final String DISCOUNT = "FALL2025";
    private final double DISCOUNT_RATE = 10.0;

    UserInteraction uI = new UserInteraction();

    /**
     * Customer checkout
     * @param customer
     * @return
     */
    public int customerCheckOut(Customer customer) {
        Cart cart = customer.getCart();
        double total = cart.getTotalPriceOfCart();
        Order order = new Order(customer.getCart().getItems(), customer, total, Status.CREATED);
        uI.printString(("Your total sum is: " + total));
        order.setTotalPrice(total);
        double tax = calculatePercentage(total, TAX);
        uI.printString(("Your total tax is: " + tax));
        String discountCode = uI.getString("Enter your discount code if any: ");
        if (discountCode.equalsIgnoreCase(DISCOUNT)) {
            uI.printString(("You are entitled to discount of  " + DISCOUNT_RATE + "%"));
            total = total - calculatePercentage(total, DISCOUNT_RATE);
            tax = calculatePercentage(total, TAX);
            uI.printString(("Your new total is " + total + " and your new tax is " + tax));
            order.setTotalPrice(total);
        } else {
            uI.printString("You are not entitled to discount.");
        }
        uI.printString("Your shipping will be " + Shipping.getShipping(total));
        total += Shipping.getShipping(total);
        uI.printString("Your total will be " + total);
        order.setTotalPrice(total);
        while (true) {
            char answer = uI.getYN("Have you payed? (Y/N): ");
            if (answer == 'Y') {
                uI.printString("Thank you for your payment, your order is now being packed");
                order.setStatus(Status.PACKED);
                break;
            } else {
                uI.printString("Sorry, your order is not being packed");
            }
        }
        return 1;
    }

    /**
     * Calculate percentage of sum sent in
     * @param sum, the sum
     * @param percentage, the percentage
     * @return double, the percentage of the sum
     */
    private double calculatePercentage(double sum, double percentage) {
        return sum * percentage / 100;
    }
}
