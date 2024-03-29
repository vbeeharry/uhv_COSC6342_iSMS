package com.uhv.cosc6342.isms.accountSubsystem.admin;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class AdminPageDeleteCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - Delete Course";
    }

    /**
     * Delete the Course
     */
    public void deleteCourse() {
        List temp = crc.readAll();

        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Course ID:" );
        Scanner in = new Scanner(System.in);
        String id = in.next();

        dm.deleteCourse(id);
    }
}
