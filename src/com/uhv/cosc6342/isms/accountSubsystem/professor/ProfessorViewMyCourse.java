package com.uhv.cosc6342.isms.accountSubsystem.professor;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 */
public class ProfessorViewMyCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Professor - My Course"; 
    }

    /**
     * View my course
     */
    public String viewMyCourse() {
        String selectedCourseId = null;
        displayTitle();

        crc.readAll();
        List semesterCourseList = crc.getCourseList();

        String myUserId = lm.getActiveUser().getUserId();

        System.out.println("Enter Course ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        boolean courseFound = false;
        for (Iterator iter = semesterCourseList.iterator(); iter.hasNext();) {
            Course course = (Course) iter.next();
            if (course.getCourseID().equals(id) && course.getProfessorId().equals(myUserId)) {
                courseFound = true;
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
                System.out.println("Syllabus Added: " + course.getSyllabusAdded());
                System.out.println("\n\n");
                selectedCourseId = id;
            }
        }

        if (!courseFound) {
            System.out.println("This course is not assigned to me.");
        }

        return selectedCourseId;
    }
}