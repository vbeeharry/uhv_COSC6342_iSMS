package com.uhv.cosc6342.isms.ui.professor;

import com.uhv.cosc6342.isms.ui.UIInterface;

/**
 * Main Professor page
 */
public class ProfessorPage0 extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Professor"; //lm.getActiveUser().toString();
        options = new String[3];
        options[0] = new String("Log out and Exit");
        options[1] = new String("View all my Courses");
        options[2] = new String("View a Course");
    }
}