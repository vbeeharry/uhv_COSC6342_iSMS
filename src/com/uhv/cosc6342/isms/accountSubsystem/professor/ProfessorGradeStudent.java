package com.uhv.cosc6342.isms.accountSubsystem.professor;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ProfessorGradeStudent extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Professor - Grade Registered Students";
    }

    /**
     * GRade student
     */
    public void gradeStudent(String courseId) {
        List temp = crsc.readAll();
        List myRegisteredStudentsList = new ArrayList();

        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Student ID:");
        Scanner in = new Scanner(System.in);
        String studentId = in.next();

        boolean studentsFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] tt = (String[]) iter.next();
            if (tt[1].equals(courseId) && tt[0].equals(studentId)) {
                studentsFound = true;
                System.out.println("\nStudent ID has been found: \n");
            }
        }

        if (!studentsFound) {
            debug.log("\nStudent ID not found.");
        }
        else {
            List temp1 = crs.readAll();
            System.out.println("\n");

            String[] studentList = (String[]) myRegisteredStudentsList.toArray(new String[myRegisteredStudentsList.size()]);
           
            for (Iterator iter = temp1.iterator(); iter.hasNext();) {
                String[] tempStudent = (String[]) iter.next();
                if (tempStudent[3].equals(studentId)) {
                    System.out.println("First Name: " + tempStudent[0]);
                    System.out.println("Last Name: " + tempStudent[1]);
                    System.out.println("Email: " + tempStudent[2]);
                    System.out.println("User ID: " + tempStudent[3]);
                    System.out.println("GPA: " + tempStudent[4]);
                    System.out.println("\n\n");
                }
            }

            System.out.println("Enter new Grade(A - F): ");
            String newGrade = in.next();
            System.out.println("\nGrade has been entererd");
        }
    }
}   
