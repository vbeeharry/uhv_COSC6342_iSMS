package com.uhv.cosc6342.isms.accountSubsystem.student;

import com.uhv.cosc6342.isms.controller.UIInterface;

/**
 * Main Student page
 */
public class StudentPage0 extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Student";
        options = new String[6];
        options[0] = new String("Log out and Exit");
        options[1] = new String("View all my Courses");
        options[2] = new String("Search for my class");
        options[3] = new String("Register for new Course");
        options[4] = new String("Drop a registered Course");
        options[5] = new String("View my payment balance");
    }
}
