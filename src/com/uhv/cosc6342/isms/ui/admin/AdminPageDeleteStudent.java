package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPageDeleteStudent extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - Delete Student Profile";
    }

    /**
     * Delete the Student
     */
    public void deleteStudent() {
        List temp = crs.readAll();

        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Student User ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();
    }
}
