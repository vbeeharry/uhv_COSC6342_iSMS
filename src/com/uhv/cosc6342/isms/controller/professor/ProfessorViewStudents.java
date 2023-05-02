package com.uhv.cosc6342.isms.controller.professor;

import com.uhv.cosc6342.isms.accountSubsystem.Student;
import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProfessorViewStudents extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Professor - View Registered Students";
    }

    /**
     * Display registered students
     */
    public void viewRegisteredStudents(String courseId) {
        List temp = crsc.readAll();
        List myRegisteredStudentsList = new ArrayList();

        System.out.println("\n");
        displayTitle();

        boolean studentsFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] tt = (String[]) iter.next();
            if (tt[1].equals(courseId)) {
                studentsFound = true;
                myRegisteredStudentsList.add(tt[0]);
            }
        }

        if (!studentsFound) {
            debug.log("\nNo students registered.");
        }
        else {
            List temp1 = crs.readAll();
            System.out.println("\n");
    
            String[] studentList = (String[]) myRegisteredStudentsList.toArray(new String[myRegisteredStudentsList.size()]);
           
            for (Iterator iter = temp1.iterator(); iter.hasNext();) {
                String[] tempStudent = (String[]) iter.next();
                for (int i = 0; i < studentList.length; i++) {
                    if (tempStudent[3].equals(studentList[i])) {
                        System.out.println("First Name: " + tempStudent[0]);
                        System.out.println("Last Name: " + tempStudent[1]);
                        System.out.println("Email: " + tempStudent[2]);
                        System.out.println("User ID: " + tempStudent[3]);
                        System.out.println("GPA: " + tempStudent[4]);
                        System.out.println("\n\n");
                    }
                }
            }   
        }
    }
}
