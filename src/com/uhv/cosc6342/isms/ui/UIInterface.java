package com.uhv.cosc6342.isms.ui;

import com.uhv.cosc6342.isms.login.LoginManagement;

import java.util.Scanner;

public abstract class UIInterface {
    
    protected LoginManagement lm;

    protected String title;
    protected String[] options;

    /**
     * Constructor
     */
    public UIInterface () {
        lm = LoginManagement.getInstance();
        init();
    }

    /**
     * Init
     */
    protected abstract void init();

    public void displayTitle() {
        System.out.println("\n***** " + title + " *****");
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

    /**
     * Enter User ID
     */
    public String getUserId() {
        System.out.println("Enter user id: ");
        Scanner in = new Scanner(System.in);
        String userId = in.next();
        return userId;
    }

    /**
     * Enter  password
     */
    public String getPassword() {
        System.out.println("Enter password: ");
        Scanner in = new Scanner(System.in);
        String password = in.next();
        return password;
    }
}
