package com.uhv.cosc6342.isms.controller.student;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class StudentPageViewMyCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Student - View my course";
        options = new String[3];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Go back");
        options[2] = new String("View Syllabus");
    }
}
