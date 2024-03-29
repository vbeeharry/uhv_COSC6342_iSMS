package com.uhv.cosc6342.isms.accountSubsystem.professor;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class ProfessorPageViewMyCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Professor - View my course";
        options = new String[5];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Go back");
        options[2] = new String("Add Syllabus");
        options[3] = new String("View Registered Students");
        options[4] = new String("Grade Student");
    }
}
