package com.uhv.cosc6342.isms.accountSubsystem.admin;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Student;

import java.util.Scanner;

public class AdminPageAddStudent extends UIInterface {    

    private String[] temp;

    /**
     * Init
     */
    protected void init() {
        title = "Admin - Add a Student";
        temp = new String[6];
    }

    /**
     * Add a student
     */
    public void addStudent() {
        displayTitle();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        temp[0] = in.next();
        System.out.println("Enter Last Name: ");
        temp[1] = in.next();
        System.out.println("Enter Email: ");
        temp[2] = in.next();
        System.out.println("User ID (8 Characters): " );
        temp[3] = in.next();
        System.out.println("Enter password: ");
        temp[4] = in.next();
        temp[5] = "student";

        
        if (temp[3].length() != 8) {
            System.out.println("\nUser ID not accepted.");
        }
        else {
            dm.addStudent(temp);
        }
    }
}
