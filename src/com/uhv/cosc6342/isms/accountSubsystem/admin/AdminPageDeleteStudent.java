package com.uhv.cosc6342.isms.accountSubsystem.admin;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.uhv.cosc6342.isms.controller.UIInterface;

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

        dm.deleteStudent(id);
    }
}
