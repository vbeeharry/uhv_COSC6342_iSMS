package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;

public class AdminPageViewStudents extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - View Students Profile";
    }

    /**
     * Display students list
     */
    public void viewStudents() {
        List temp = crs.readAll();
        System.out.println("\n");
        displayTitle();

        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] str = (String[]) iter.next();
            System.out.println("First Name: " + str[0]);
            System.out.println("Last Name: " + str[1]);
            System.out.println("Email: " + str[2]);
            System.out.println("User ID: " + str[3]);
            System.out.println("GPA: " + str[4]);
            System.out.println("\n\n");
        }
    }
}
