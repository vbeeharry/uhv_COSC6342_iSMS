package com.uhv.cosc6342.isms.ui.student;

import com.uhv.cosc6342.isms.courses.Course;
import com.uhv.cosc6342.isms.users.Student;
import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 */
public class StudentRegisterCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - Register Course"; 
    }

    /**
     * Register a course
     */
    public void registerCourse() {
        List temp = crc.readAll();
        Student student = (Student) lm.getActiveUser();

        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Course ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        boolean courseFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            Course course = (Course) iter.next();
            if (course.getId().equals(id)) {
                courseFound = true;
                dm.addStudentCourse(student, course);
            }
        }

        if (!courseFound) {
            debug.log("\nCourse ID not found. Course not registered.");
        }
    }
}