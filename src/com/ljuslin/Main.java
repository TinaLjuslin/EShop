package com.ljuslin;

import com.ljuslin.util.Utils;

/**
 * E-handel/kassa – varukorg, order & rabatter
 * Skapa en enkel e-handel där användare kan lägga varor i en varukorg, gå till
 * kassan och skapa order. Systemet ska hantera moms, frakt,
 * kupongkoder/rabatter, lagersaldo och returer. Orderns status ska kunna följas
 * från skapad till levererad.
 */
public class Main {

    public static void main(String[] args) {
        Utils m = new Utils();
        m.start();
    }
}
