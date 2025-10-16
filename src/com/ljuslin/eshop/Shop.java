package com.ljuslin.eshop;

import com.ljuslin.userinteraction.UserInteraction;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    UserInteraction uI = new UserInteraction();
    List<Item> items = new ArrayList<>();
    List<Employee> employees = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();

    /**
     * Constructor, starts the shop and adds items
     */
    public Shop() {
        items.add(new Item("Radiostyrd bil", "Röd bil som går att radiostyra", 459, 20));
        items.add(new Item("Hårfärg", "Röd permanent hårfärg", 81, 10));
        items.add(new Item("Klänning", "Röd tight klänning", 849, 20));
        items.add(new Item("Läppstift", "Intensivt rött läppstift", 110, 15));
        items.add(new Item("Ferrari", "Röd ferrari", 1230000, 2));
        items.add(new Item("Köksbord", "Rött köksbord utan stolar", 1200, 4));
        items.add(new Item("Köksstol", "Röd köksstol", 349, 12));
        items.add(new Item("Mobiltelefon", "Röd mobiltelefon som är jättehäftig", 2999, 7));
        items.add(new Item("Mössa", "Röd mössa med tofs", 129, 32));
        items.add(new Item("Hammare", "Hammare med rött skaft", 250, 32));

        customers.add(new Customer("Anna", "Andersson", "pass"));
    }

    /**
     * Searches all employees for an employee by username
     * @param username, the username of the employee to look for
     * @return Employee, the employee to look for
     */
    public Employee getEmployee(String username) {
        for (Employee employee : employees) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Searches for a customer by username
     * @param username, the username to look for
     * @return Customer, the customer
     */
    public Customer getCustomer(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Add item to cart
     * @param customer, customer the cart belong to
     */
    public void addToCart(Customer customer) {
        listAllItems(customer);
        int choice = uI.getInt("Which item would you like to buy?");
        if (choice > 0 && choice < items.size()) {
            customer.addToCart(items.get(choice - 1));
            items.get(choice -1).retractFromQuantity(1);
        }
    }

    /**
     * Empty customers cart
     * @param customer, the owner of the cart
     */
    public void emptyCart(Customer customer) {
        customer.emptyCart();
    }

    /**
     * Creates a new customer to shop
     */
    public void newCustomer() {
        String firstName = uI.getString("Please enter first name:");
        String lastName = uI.getString("Please enter last name:");
        String password = uI.getString("Please enter password:");
        Customer customer = new Customer(firstName, lastName, password);
        customers.add(customer);
        uI.printString("Welcome " + firstName + " " + lastName + ", your username is "
                + customer.getUsername());
    }

    /**
     * List all items in shop
     */
    public void listAllItems(Customer customer) {
        for(int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ", " + items.get(i));
        }
    }

    /**
     * List all items in shop with quantity
     */
    public void listAllItems() {
        for(int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ", "+ items.get(i) + ", Quantity: "
                    + String.valueOf(items.get(i).getQuantity()));
        }
    }

    /**
     * List items in customers cart
     * @param customer the customer to list cart for
     */
    public void listCart(Customer customer) {
        Cart cart = customer.getCart();
        for (int i = 0; i < cart.items.size(); i++) {
            uI.printString((i + 1) + ", " + cart.items.get(i));
        }
        double total = cart.getTotalPriceOfCart();
        uI.printString(("Total price of cart: " + total));
    }

    /**
     * Search for items that fits what user writes in prompt
     */
    public void searchItem() {
        String itemDesc = (uI.getString("What are you looking for?")).toLowerCase();
        ArrayList<Item> itemFits = new ArrayList<>();
        for (Item item : items) {
            if (item.getDescription().toLowerCase().contains(itemDesc) ||
                item.getName().toLowerCase().contains(itemDesc)) {
                itemFits.add(item);
            }
        }
        for (int i = 0; i < itemFits.size(); i++) {
            uI.printString((i + 1) + ", " + itemFits.get(i));
        }
    }

    /**
     * List customers items in cart, prompts user which one to remove, remove it
     * @param customer, the customer to remove item for
     */
    public void removeFromCart(Customer customer) {
        listCart(customer);
        int choice = uI.getInt("Which item would you like to  remove?");
        Item item = customer.getCart().getItems().get(choice - 1);
        if (choice > 0 && choice < customer.getCart().getItems().size()) {
            customer.getCart().removeItem(item);
        }
    }

    /**
     * Customer goes to checkout
     * @param customer, the customer to check out
     */
    public void goToCheckout(Customer customer) {
    Checkout co = new Checkout();
    co.customerCheckOut(customer);
    }

    /**
     * Return item to chop
     */
    public void returnItem(Customer customer) {
        *********************************************''

    }
}
