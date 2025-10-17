package com.ljuslin.eshop;

import com.ljuslin.userinteraction.UserInteraction;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private UserInteraction uI = new UserInteraction();
    private List<Item> items = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private Checkout co = new Checkout();
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
        List<Item> buyItems = searchItem();
        if ( buyItems == null ) {
            return;
        }
        int choice = uI.getInt("Which item would you like to buy?");
        choice -= 1;
        if (choice >= 0 && choice < buyItems.size()) {
            if (buyItems.get(choice) != null) {
                if (items.contains(buyItems.get(choice))) {
                    for (Item item : items) {
                        if (item.equals(buyItems.get(choice))) {
                            item.retractFromQuantity(1);
                            customer.addToCart(item);
                            uI.printString((item.toString() + " added to cart"));
                            return;
                        }
                    }
                }
            } else {
                uI.printString("No items found");
            }
        } else {
            uI.printString("Incorrect choice");
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
    public int listCart(Customer customer) {
        Cart cart = customer.getCart();
        if (cart != null && cart.getItems().size() > 0) {
            for (int i = 0; i < cart.items.size(); i++) {
                uI.printString((i + 1) + ", " + cart.items.get(i));
            }
            double total = cart.getTotalPriceOfCart();
            uI.printString(("Total price of cart: " + total));
            return cart.getItems().size();
        } else {
            uI.printString("Cart is empty.");
            return 0;
        }
    }
    /**
     * Search for items that fits what user writes in prompt
     */
    public List<Item> searchItem() {
        String itemDesc = (uI.getString("What are you looking for?")).toLowerCase();
        ArrayList<Item> itemFits = new ArrayList<>();
        for (Item item : items) {
            if (item.getDescription().toLowerCase().contains(itemDesc) ||
                item.getName().toLowerCase().contains(itemDesc)) {
                itemFits.add(item);
            }
        }
        if ( itemFits.isEmpty()) {
            uI.printString("No items found");
            return null;
        }
        for (int i = 0; i < itemFits.size(); i++) {
            uI.printString(((i + 1) + ", " + itemFits.get(i)) + ", Quantity: "
                    + String.valueOf(itemFits.get(i).getQuantity()));
        }
        return itemFits;
    }

    /**
     * List customers items in cart, prompts user which one to remove, remove it
     * @param customer, the customer to remove item for
     */
    public void removeFromCart(Customer customer) {
        int sizeOfCart = listCart(customer);
        if (sizeOfCart > 0) {
            int choice = uI.getInt("Which item would you like to  remove?");
            choice -= 1;
            if (choice >= 0 && choice < sizeOfCart) {
                Item item = customer.getCart().getItems().get(choice);
                if (choice >= 0 && choice < customer.getCart().getItems().size()) {
                    item.addToQuantity(1);
                    customer.getCart().removeItem(item);
                    uI.printString(item.toString() + " removed from cart");
                }
            } else {
                uI.printString("Incorrect choice");
            }
        }
    }

    /**
     * Customer goes to checkout
     * @param customer, the customer to check out
     */
    public void goToCheckout(Customer customer) {
    if (customer.getCart().getItems().isEmpty()) {
        uI.printString("Cart is empty");
        return;
        }
    co.customerCheckOut(customer);
    customer.emptyCart();
    }

    /**
     * Return item to chop
     */
    public void returnItem(Customer customer) {
        List<Item> returnItems = searchItem();
        if ( returnItems == null ) {
            return;
        }
        int choice = uI.getInt("Which item would you like to return?");
        choice -= 1;
        if (choice >= 0 && choice < returnItems.size()) {
            if (returnItems.get(choice) != null) {
                if (items.contains(returnItems.get(choice))) {
                    for (Item item : items) {
                        if (item.equals(returnItems.get(choice))) {
                            item.addToQuantity(1);
                            co.returnItem(customer, item);
                        }
                    }
                }
            } else {
                uI.printString("No items found");
            }
        } else {
            uI.printString("Incorrect choice");
        }

    }
}
