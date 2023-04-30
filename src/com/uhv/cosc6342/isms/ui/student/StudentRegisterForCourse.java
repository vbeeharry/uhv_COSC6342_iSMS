package com.uhv.cosc6342.isms.ui.student;

import com.uhv.cosc6342.isms.courses.Course;
import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;

/**
 */
public class StudentRegisterForCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - Register For Course"; 
        options = new String[4];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Go back");
        options[2] = new String("View available courses");
        options[3] = new String("Register course");
    }
}