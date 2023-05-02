package com.uhv.cosc6342.isms.accountSubsystem.admin;

import java.util.Iterator;
import java.util.List;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class AdminPageViewProfessors extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - View Professors Profile";
    }

    /**
     * Display professors list
     */
    public void viewProfessors() {
        List temp = crp.readAll();
        System.out.println("\n");
        displayTitle();

        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] str = (String[]) iter.next();
            System.out.println("First Name: " + str[0]);
            System.out.println("Last Name: " + str[1]);
            System.out.println("Email: " + str[2]);
            System.out.println("User ID: " + str[3]);
            System.out.println("\n\n");
        }
    }
}
