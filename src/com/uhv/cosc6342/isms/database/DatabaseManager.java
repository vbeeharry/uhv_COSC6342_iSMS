package com.uhv.cosc6342.isms.database;

import com.uhv.cosc6342.isms.users.Admin;
import com.uhv.cosc6342.isms.users.Professor;
import com.uhv.cosc6342.isms.users.Student;
import com.uhv.cosc6342.isms.users.User;
import com.uhv.cosc6342.isms.utils.Constants;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.Debug;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

public class DatabaseManager implements Constants {

    public static DatabaseManager dm = null;

    private CsvReaderUser cr;
    private Debug debug;

    /**
     * Private constructor
     */
    private DatabaseManager() { 
        init();
    }

    /**
     * init
     */
    public void init() {
        debug = Debug.getInstance();
        cr = CsvReaderUser.getInstance(USERS_FILE); cr.readAll();

        try {
            debug.log("Checking Admins File");
            File adminsFile = new File(ADMINS_FILE);
            if (!adminsFile.exists()) {
                adminsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            debug.log("Checking Professors File");
            File professorsFile = new File(PROFESSORS_FILE);
            if (!professorsFile.exists()) {
                professorsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            debug.log("Checking Students File");
            File studentsFile = new File(STUDENTS_FILE);
            if (!studentsFile.exists()) {
                studentsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        writeToAdminsFile();
        writeToProfessorsFile();
        writeToStudentsFile();
    }

    /**
     * Write to admins file
     */
    public void writeToAdminsFile() {
        try {
            FileWriter fw = new FileWriter(ADMINS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cr.getAdminList().iterator(); iter.hasNext();) {
                Admin temp = (Admin) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + "\n");
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Write to professors file
     */
    public void writeToProfessorsFile() {
        try {
            FileWriter fw = new FileWriter(PROFESSORS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cr.getProfessorList().iterator(); iter.hasNext();) {
                Professor temp = (Professor) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + "\n");
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to students file
     */
    public void writeToStudentsFile() {
        try {
            FileWriter fw = new FileWriter(STUDENTS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cr.getStudentList().iterator(); iter.hasNext();) {
                Student temp = (Student) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + ","
                    + temp.getGpa() + "\n") ;
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to user file
     */
    private void writeToUserFile(User user, String role) {
        try {
            FileWriter fw = new FileWriter(USERS_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user.getFirstName() + "," 
                    + user.getLastName() + ","
                    + user.getEmail() + ","
                    + user.getUserId() + ","
                    + user.getPassword() + ","
                    + role + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to student file
     */
    private void writeToStudentFile(Student student) {
        try {
            FileWriter fw = new FileWriter(STUDENTS_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(student.getFirstName() + "," 
                    + student.getLastName() + ","
                    + student.getEmail() + ","
                    + student.getUserId() + ","
                    + student.getGpa() + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Add a student to the school database
     */
    public void addStudent(Student student) {
        debug.log("Adding a new student");
        writeToUserFile(student, "student");
        writeToStudentFile(student);
    }

    /**
     * Singleton instance
     */
    public static DatabaseManager getInstance() {
        if (dm == null) dm = new DatabaseManager();
        return dm;
    }
}
