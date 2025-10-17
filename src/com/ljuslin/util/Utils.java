package com.ljuslin.util;

import com.ljuslin.eshop.Customer;
import com.ljuslin.eshop.Shop;
import com.ljuslin.userinteraction.UserInteraction;

public class Utils {
    //Constants
    private final String USERNAME = "Please enter username (enter): ";
    private final String LAST_NAME =  "Please enter last name (enter): ";
    private final String CUSTOMER_NOT_FOUND = "Customer not found";
    private final String FIRST_NAME = "Please enter first name (enter): ";
    private final String INCORRECT_PASSW = "Incorrect password, please try again";
    private final String INCORRECT_CHOICE = "Incorrect choice, please try again";
    private final String PASSWORD = "Please enter password (enter): ";
    public final String EMPLOYEE_NOT_FOUND = "Employee not found";

    private UserInteraction uI = new UserInteraction();
    Shop shop = new Shop();

    /**
     * Starts the shop by printing first menu
     */
    public void start() {
        while (true) {
            switch (uI.printMainMenuGetChoice()) {
                case 1 -> customerLogIn();
                case 2 -> shop.newCustomer();
                case 3 -> employeeLogIn();
                case 4 -> System.exit(0);
                default -> uI.printString("Incorrect choice, please try again");
            }
        }
    }

    /**
     * Employee log in
     */
    private void employeeLogIn() {
        /*while (true) {
            String username = uI.getString(USERNAME);
            String password = uI.getString(PASSWORD);
            Employee employee = shop.getEmployee(username);
            if (employee != null) {
                if (employee.getPassword().equals(password)) {
                    break;
                } else {
                    uI.printString(INCORRECT_PASSW);
                }
            } else {
                uI.printString(EMPLOYEE_NOT_FOUND);
            }
        }

        boolean goOn = true;
        while (goOn) {
            switch (uI.printEmployeeMenuGetChoice()) {
                case 1 -> shop.newCustomer();
                case 2 ->  goOn = false;
                default -> uI.printString(INCORRECT_CHOICE);
            }
        }*/
    }

    /**
     * Customer log in
     */
    private void customerLogIn() {
        String username = uI.getString(USERNAME);
        String userPassword = uI.getString(PASSWORD);
        Customer customer = shop.getCustomer(username);
        if (customer != null) {
            if (customer.getPassword().equals(userPassword)) {
                boolean goOn = true;
                while (goOn) {
                    switch (uI.printCustomerMenuGetChoice()) {
                        case 1 -> shop.listAllItems(customer);
                        case 2 -> shop.searchItem();
                        case 3 -> shop.addToCart(customer);
                        case 4 -> shop.removeFromCart(customer);
                        case 5 -> shop.listCart(customer);
                        case 6 -> shop.emptyCart(customer);
                        case 7 -> shop.goToCheckout(customer);
                        case 8 -> shop.returnItem(customer);
                        case 9 -> goOn = false;
                        default -> uI.printString("Incorrect choice, please try again");
                    }
                }
            } else {
                uI.printString("Incorrect password, please try again");
            }
        } else {
            uI.printString("Customer not found");
        }
    }
}
