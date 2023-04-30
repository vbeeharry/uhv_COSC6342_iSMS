package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPageViewStudent extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - View Student Profile";
    }

    /**
     * Display the student
     */
    public void viewStudent() {
        List temp = crs.readAll();
        
        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Student User ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        boolean studentFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] str = (String[]) iter.next();
            if (str[3].equals(id)) {
                studentFound = true;
                System.out.println("First Name: " + str[0]);
                System.out.println("Last Name: " + str[1]);
                System.out.println("Email: " + str[2]);
                System.out.println("User ID: " + str[3]);
                System.out.println("GPA: " + str[4]);
                System.out.println("\n\n");
                break;
            }
        }

        if (!studentFound) {
            debug.log("Student ID not found");
        }
    }
}
