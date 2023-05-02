package com.uhv.cosc6342.isms.controller;

import com.uhv.cosc6342.isms.databaseSubsystem.DatabaseManager;
import com.uhv.cosc6342.isms.loginSubsystem.LoginManagement;
import com.uhv.cosc6342.isms.utils.Constants;
import com.uhv.cosc6342.isms.utils.CsvReaderCourse;
import com.uhv.cosc6342.isms.utils.CsvReaderProfessor;
import com.uhv.cosc6342.isms.utils.CsvReaderStudent;
import com.uhv.cosc6342.isms.utils.CsvReaderStudentCourse;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.Debug;

import java.util.Scanner;

public abstract class UIInterface {
    
    protected LoginManagement lm;
    protected DatabaseManager dm;

    protected String title;
    protected String[] options;

    protected CsvReaderUser cru;
    protected CsvReaderStudent crs;
    protected CsvReaderProfessor crp;
    protected CsvReaderCourse crc;
    protected CsvReaderStudentCourse crsc;

    protected Debug debug;

    /**
     * Constructor
     */
    public UIInterface () {
        initMe();
        init();
    }

    /**
     * initMe
     */
    private void initMe() {
        lm = LoginManagement.getInstance();
        dm = DatabaseManager.getInstance();
        cru = CsvReaderUser.getInstance(Constants.USERS_FILE);
        crp = CsvReaderProfessor.getInstance(Constants.PROFESSORS_FILE);
        crs = CsvReaderStudent.getInstance(Constants.STUDENTS_FILE);
        crc = CsvReaderCourse.getInstance(Constants.COURSES_FILE);
        crsc = CsvReaderStudentCourse.getInstance(Constants.STUDENT_COURSE_FILE);
        debug = Debug.getInstance();
    }

    /**
     * Init
     */
    protected abstract void init();

    public void displayTitle() {
        System.out.println("\n***** " + title + " *****");
    }

    public void displayOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.println(i + " : " + options[i]);
        }
        
        System.out.println("\n");
    }

    public int getSelection() {
        System.out.println("Enter selection: ");
        Scanner in = new Scanner(System.in);
        int selection = in.nextInt();
        return selection;
    }

    /**
     * Enter User ID
     */
    public String getUserId() {
        System.out.println("Enter user id: ");
        Scanner in = new Scanner(System.in);
        String userId = in.next();
        return userId;
    }

    /**
     * Enter  password
     */
    public String getPassword() {
        System.out.println("Enter password: ");
        Scanner in = new Scanner(System.in);
        String password = in.next();
        return password;
    }
}
