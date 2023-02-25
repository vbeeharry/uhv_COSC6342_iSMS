package com.uhv.cosc6342.isms;

/**
 * For the iSMS project.
 */
public class Main {

    private int a;
    private int b;

    public static void main(String[] args) {
        System.out.println("Hello World");

        Main m = new Main();
        m.init();
        int s = m.sum();
        System.out.println("The sum is: " + s);
    }

    private void init() {
        a = 10;
        b = 30;
    }

    private int sum() {
        int total = a + b;
        for (int i = 0; i < total; i++) {
            System.out.println(total);
        }
        
        return total;
    }
}