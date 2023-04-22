package com.uhv.cosc6342.isms.ui;

import java.util.Scanner;

public abstract class UIInterface {
    
    protected String title;
    protected String[] options;

    public void displayTitle() {
        System.out.println("***** " + title + " *****");
    }

    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " : " + options[i]);
        }
        
        System.out.println("\n");
    }

    public int getSelection() {
        System.out.println("Enter selection: ");
        Scanner in = new Scanner(System.in);
        int selection = in.nextInt();
        return selection;
    }
}
