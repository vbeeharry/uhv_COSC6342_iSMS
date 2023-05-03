package com.uhv.cosc6342.isms.accountSubsystem.admin;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;

import java.util.Scanner;

public class AdminPageAddCourse extends UIInterface {    

    private String[] temp;

    /**
     * Init
     */
    protected void init() {
        title = "Admin - Add a Course";
        temp = new String[11];
    }

    /**
     * Add a course
     */
    public void addCourse() {
        displayTitle();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Course ID: ");
        temp[0] = in.next();
        System.out.println("Enter Course name: ");
        temp[1] = in.next();
        System.out.println("Enter Teaching Day: ");
        temp[2] = in.next();
        System.out.println("Enter Total Seats Available: " );
        temp[3] = in.next();
        temp[4] = Integer.toString(0);
        temp[5] = temp[3];
        System.out.println("Enter Instruction Mode: ");
        temp[6] = in.next();
        System.out.println("Enter Room number: ");
        temp[7] = in.next();
        System.out.println("Enter Start date: " );
        temp[8] = in.next();
        System.out.println("Enter End date: " );
        temp[9] = in.next();
        System.out.println("Enter Professor id: ");
        temp[10] = in.next();
        
        dm.addCourse(temp);
    }
}
