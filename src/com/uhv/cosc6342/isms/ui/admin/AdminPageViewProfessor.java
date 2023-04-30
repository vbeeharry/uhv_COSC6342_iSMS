package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPageViewProfessor extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - View Professor Profile";
    }

    /**
     * Display the professor
     */
    public void viewProfessor() {
        List temp = crp.readAll();
        
        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Professor User ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] str = (String[]) iter.next();
            if (str[3].equals(id)) {
                System.out.println("First Name: " + str[0]);
                System.out.println("Last Name: " + str[1]);
                System.out.println("Email: " + str[2]);
                System.out.println("User ID: " + str[3]);
                System.out.println("\n\n");
                break;
            }
        }
    }
}
