package com.uhv.cosc6342.isms.accountSubsystem.professor;

import com.uhv.cosc6342.isms.controller.UIInterface;
import com.uhv.cosc6342.isms.utils.FileChooser;

public class ProfessorAddSyllabus extends UIInterface {

    private FileChooser fc;
    
    /**
     * Init
     */
    protected void init() {
        title = "Professor - Add Syllabus";
        fc = new FileChooser("TXT Files", "txt");
    }

    /**
     * Add Syllabus
     */
    public void addSyllabus(String courseId) {
        fc.execute();
        fc.display(courseId + "_syllabus.syl");
        System.out.println("\nSyllabus has now been added");
    }
}
