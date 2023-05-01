package com.uhv.cosc6342.isms.ui.professor;

import com.uhv.cosc6342.isms.ui.UIInterface;

public class ProfessorPageViewMyCourse extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Professor - View my course";
        options = new String[4];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Go back");
        options[2] = new String("View Registered Students");
        options[3] = new String("Grade Students");
    }
}
