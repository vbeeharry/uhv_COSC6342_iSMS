package com.uhv.cosc6342.isms.accountSubsystem.student;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.courseSubsystem.Course;

import java.util.Iterator;
import java.util.List;

/**
 */
public class StudentViewAvailableCourses extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - Available Courses"; 
    }

    /**
     * View my courses
     */
    public void viewMyCourses() {
        displayTitle();

        crc.readAll();
        List semesterCourseList = crc.getCourseList();

        for (Iterator iter = semesterCourseList.iterator(); iter.hasNext();) {
            Course course = (Course) iter.next();
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
        }
    }
}