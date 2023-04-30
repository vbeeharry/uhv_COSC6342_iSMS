package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.courses.Course;
import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPageViewCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - View Course";
    }

    /**
     * Display the course
     */
    public void viewCourse() {
        List temp = crc.readAll();
        
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
                System.out.println("\n\n");
                break;
            }
        }

        if (!courseFound) {
            debug.log("Course ID not found.");
        }
    }
}
