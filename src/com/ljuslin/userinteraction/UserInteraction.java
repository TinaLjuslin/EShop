/**
 * handles interaction with the user
 * @author tina.ljuslin@studerande.yh.se
 */
package com.ljuslin.userinteraction;

import java.util.Scanner;

public class UserInteraction {
    private Scanner scanner = new Scanner(System.in);

    /**
     * gets and returns users first menu choice
     * @return
     */
    public int printMainMenuGetChoice() {
        printFirstMenu();
        return getUserChoice();
    }

    /**
     * prints a string
     * @param string, the string to print
     */
    public void printString(String string) {
        System.out.println(string);
    }

    /**
     * Prints the first menu
     */
    private void printFirstMenu() {
        System.out.println("1. Customer log in");
        System.out.println("2. Create new customer");
        System.out.println("3. Employee log in");
        System.out.println("4. Exit");
    }

    /**
     * gets and returns the customers choice from menu
     * @return int, the users choice
     */
    public int printCustomerMenuGetChoice() {
        printCustomerMenu();
        return getUserChoice();
    }

    /**
     * Gets a new string from the prompt
     * @return String, string from prompt
     */
    private String getUserString() {
        return scanner.nextLine();
    }

    /**
     * Waits to get the user choice from the prompt
     * @return int, the menu choice the user made, -1 if incorrect
     */
    private int getUserChoice() {
        int answer;
        try {
            answer = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
        scanner.nextLine();
        return answer;
    }

    /**
     * Prompts and asks for Y or N, y or n
     * @param string, the prompt
     * @return char Y or N
     */
    public char getYN(String string) {
        char answer;
        System.out.println(string);
        try {
            answer = scanner.nextLine().charAt(0);
        } catch (Exception e) {
            scanner.nextLine();
            return 'N';
        }
        if (answer == 'Y' || answer == 'y') {
            return 'Y';
        } else {
            return 'N';
        }
    }

    /**
     * Prompts a user to enter an int
     * @param string, the text to write in prompt
     * @return int, the users integer
     */
    public int getInt(String string) {
        System.out.println(string);
        return getUserChoice();
    }

    /**
     * Prompts the user for a string using the string sent in
     * @param string, the prompt for user
     * @return String, the string the user entered
     */
    public String getString(String string) {
        System.out.println(string);
        return getUserString();
    }

    /**
     * Employees menu
     * @return int, employees choice
     */
    public int printEmployeeMenuGetChoice() {
        printEmployeeMenu();
        return getUserChoice();
    }

    /**
     * Print employee menu
     */
    private void printEmployeeMenu() {
        System.out.println();
    }

    /**
     * Prints the customers menu
     */
    private void printCustomerMenu() {
        System.out.println("1. List all items");
        System.out.println("2. Search for item");
        System.out.println("3. Add item to cart");
        System.out.println("4. Delete item from cart");
        System.out.println("5. List my cart");
        System.out.println("6. Empty my cart");
        System.out.println("7. Go to checkout");
        System.out.println("8. Make a return");
        System.out.println("9. Log out");
    }

}
