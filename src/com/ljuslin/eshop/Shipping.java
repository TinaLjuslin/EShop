package com.ljuslin.eshop;

public class Shipping {
    public Shipping() {

    }
    static public double getShipping(double total) {

        if (total < 300) return 99;
        else if (total < 500) return 59;
        else if (total < 800) return 29;
        return 0;
    }
}
