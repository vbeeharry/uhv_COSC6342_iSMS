package com.uhv.cosc6342.isms.accountSubsystem.student;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 */
public class StudentDropCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - Drop Course"; 
    }

    /**
     * Drop a course
     */
    public void dropCourse() {
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
            if (course.getCourseID().equals(id)) {
                courseFound = true;
                dm.dropStudentCourse(student, course);
            }
        }

        if (!courseFound) {
            debug.log("Course ID not found.");
        }
    }
}