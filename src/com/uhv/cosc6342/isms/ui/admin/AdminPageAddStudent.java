package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;
import com.uhv.cosc6342.isms.users.Student;

import java.util.Scanner;

public class AdminPageAddStudent extends UIInterface {    

    /**
     * Init
     */
    protected void init() {
        title = "Admin - Add a Student";
    }

    /**
     * Add a student
     */
    public void addStudent() {
        displayTitle();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = in.next();
        System.out.println("Enter Last Name: ");
        String lastName = in.next();
        System.out.println("Enter Email: ");
        String email = in.next();
        System.out.println("User ID: " );
        String id = in.next();
        System.out.println("Enter password: ");
        String password = in.next();
        String role = "student";

        Student newStudent = new Student(new String[] {
            firstName, lastName, email, id, password, role });
        dm.addStudent(newStudent);
    }
}
