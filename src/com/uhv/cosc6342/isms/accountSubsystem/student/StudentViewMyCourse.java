package com.uhv.cosc6342.isms.accountSubsystem.student;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Student;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 */
public class StudentViewMyCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - My Course"; 
    }

    /**
     * View a course
     */
    public String viewMyCourse() {
        String selectedCourseId = null;

        List temp = crsc.readAll();
        Student student = (Student) lm.getActiveUser();

        System.out.println("\n");
        displayTitle();

        String myUserId = lm.getActiveUser().getUserId();

        System.out.println("Enter Course ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        boolean courseFound = false;
        for (Iterator iter = temp.iterator(); iter.hasNext();) {
            String[] tt = (String[]) iter.next();
            if (tt[0].equals(student.getUserId()) && tt[1].equals(id)) {
                courseFound = true;
            }
        }

        if (!courseFound) {
            debug.log("\nStudent did not register for this course.");
        }
        else {
            List temp1 = crc.readAll();
            System.out.println("\n");
    
            for (Iterator iter = temp1.iterator(); iter.hasNext();) {
                Course course = (Course) iter.next();
                if (course.getCourseID().equals(id)) {
                    System.out.println("Course ID: " + course.getCourseID());
                    System.out.println("Name: " + course.getName());
                    System.out.println("Day: " + course.getDay());
                    System.out.println("Total Seats " + course.getNumOfSeatsTotal());
                    System.out.println("Seats Taken: " + course.getNumOfSeatsTaken());
                    System.out.println("Seats Available: " + course.getNumOfAvailableSeats());
                    System.out.println("Instruction Mode: " + course.getInstructionMode());
                    System.out.println("Room: " + course.getRoom());
                    System.out.println("Start Date: " + course.getStartDate());
                    System.out.println("End Date: " + course.getEndDate());
                    System.out.println("Professor ID: " + course.getProfessorId());
                    System.out.println("Syllabus Added: " + course.getSyllabusAdded());
                    System.out.println("\n\n");  
                    selectedCourseId = id;
                }
            }   
        }

        return selectedCourseId;
    }
}