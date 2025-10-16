package com.ljuslin.eshop;

import com.ljuslin.util.People;

public class Employee extends People {
    private String username;
    private String password;
    private static int counter = 100;

    /**
     * Empty constructor
     */
    public Employee() {
        this("Unknown", "Unknown", "1234");
    }

    /**
     * Constructor, saves attribute to new employee, creates unique user id
     * @param firstName, new first name
     * @param lastName, new
     * @param password, new password
     */
    public Employee(String firstName, String lastName, String password) {
        super(firstName, lastName);
        this.username = "EM-" + String.valueOf(counter++);
        this.password = password;
    }

    /**
     * Returns username
     * @return String, username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username
     * @param username, new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns password
     * @return String, password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets new password
     * @param password new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Overrides toString()
     * @return String, Employee as string
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + ", username = " + username + ", password = "
                + password;
    }
}

