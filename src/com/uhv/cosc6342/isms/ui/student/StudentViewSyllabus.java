package com.uhv.cosc6342.isms.ui.student;

import com.uhv.cosc6342.isms.ui.UIInterface;

import com.uhv.cosc6342.isms.utils.ReadAFile;

public class StudentViewSyllabus extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Student - View Syllabus";
    }

    /**
     * View Syllabus
     */
    public void viewSyllabus(String courseId) {
        ReadAFile raf = new ReadAFile(courseId + "_Syllabus.syl");
        raf.read();
    }
}
