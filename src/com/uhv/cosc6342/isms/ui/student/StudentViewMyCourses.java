package com.uhv.cosc6342.isms.ui.student;

import com.uhv.cosc6342.isms.courses.Course;
import com.uhv.cosc6342.isms.users.Student;
import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 */
public class StudentViewMyCourses extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - My Courses"; 
    }

    /**
     * Register a course
     */
    public void viewMyCourses() {
        List temp = crsc.readAll();
        Student student = (Student) lm.getActiveUser();

        List myRegisteredCoursesList = new ArrayList();

        System.out.println("\n");
        displayTitle();

        boolean courseFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] tt = (String[]) iter.next();
            if (tt[0].equals(student.getUserId())) {
                courseFound = true;
                myRegisteredCoursesList.add(tt[1]);
            }
        }

        if (!courseFound) {
            debug.log("\nNo courses registered.");
        }
        else {
            List temp1 = crc.readAll();
            System.out.println("\n");
    
            String[] courseList = (String[]) myRegisteredCoursesList.toArray(new String[myRegisteredCoursesList.size()]);

            for (Iterator iter = temp1.iterator(); iter.hasNext();) {
                Course course = (Course) iter.next();
                for (int i = 0; i < courseList.length; i++) {
                    if (courseList[i].equals(course.getId())) {
                        System.out.println("Course ID: " + course.getId());
                        System.out.println("Name: " + course.getName());
                        System.out.println("Day: " + course.getDay());
                        System.out.println("Total Seats " + course.getNumOfSeatsTotal());
                        System.out.println("Seats Taken: " + course.getNumOfSeatsTaken());
                        System.out.println("Seats Available: " + course.getNumOfSeatsAvailable());
                        System.out.println("Instruction Mode: " + course.getInstructionMode());
                        System.out.println("Room: " + course.getRoom());
                        System.out.println("Start Date: " + course.getStartDate());
                        System.out.println("End Date: " + course.getEndDate());
                        System.out.println("Professor ID: " + course.getProfessorId());
                        System.out.println("\n\n");  
                    }
                }
            }   
        }
    }
}