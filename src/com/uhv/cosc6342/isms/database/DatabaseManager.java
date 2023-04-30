package com.uhv.cosc6342.isms.database;

import com.uhv.cosc6342.isms.users.Admin;
import com.uhv.cosc6342.isms.users.Professor;
import com.uhv.cosc6342.isms.users.Student;
import com.uhv.cosc6342.isms.users.User;
import com.uhv.cosc6342.isms.utils.Constants;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.CsvReaderStudent;
import com.uhv.cosc6342.isms.utils.CsvWriter;
import com.uhv.cosc6342.isms.utils.Debug;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class DatabaseManager implements Constants {

    public static DatabaseManager dm = null;

    private CsvReaderUser cru;
    private CsvReaderStudent crs;
    private CsvWriter cw;

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
        cru = CsvReaderUser.getInstance(USERS_FILE); cru.readAll();
        crs = CsvReaderStudent.getInstance(STUDENTS_FILE); crs.readAll();
        cw = CsvWriter.getInstance();

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
            
            for (Iterator iter = cru.getAdminList().iterator(); iter.hasNext();) {
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
            
            for (Iterator iter = cru.getProfessorList().iterator(); iter.hasNext();) {
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
            
            for (Iterator iter = cru.getStudentList().iterator(); iter.hasNext();) {
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
    public void addStudent(String[] temp) {
        debug.log("Adding a new student");

        boolean okToAdd = checkIfIdExists(cru, temp);
        if (okToAdd) {
            Student tempStudent = new Student(temp);
            writeToUserFile(tempStudent, "student");
            writeToStudentFile(tempStudent);
        }
        else {
            System.out.println("Unable to add Student. User ID Already exists.");
        }
    }

    /**
     * Check if user id already exists
     */
    private boolean checkIfIdExists(CsvReaderUser cru, String[] temp) {
        boolean result = true;
        List user = cru.getUserList();

        for (Iterator iter = user.iterator(); iter.hasNext();) {
            User tempUser = (User) iter.next();
            if (tempUser.getUserId().equals(temp[3])) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Delete a student from the school database
     */
    public void deleteStudent(String id) {
        int studentIndex = okToDeleteStudent(id);

        if (studentIndex != -1) {
            deleteFromStudentsFile(studentIndex);            
        }
    }

    /**
     * Check if ok to delete
     */
    private int okToDeleteStudent(String id) {
        int result = -1;
        List student = crs.getUserList();

        int i = 0;
        for (Iterator iter = student.iterator(); iter.hasNext();) {
            String[] tempStudent = (String[]) iter.next();
            if (tempStudent[3].equals(id)) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }

    /**
     * Delete frrom students file
     */
    private void deleteFromStudentsFile(int index) {
        List students = crs.getUserList();
        students.remove(index);
        debug.log("Student deleted - User ID: " + index);

        List temp = students;

        try {
            File file = new File(STUDENTS_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAll(STUDENTS_FILE, temp);
    }

    /**
     * Singleton instance
     */
    public static DatabaseManager getInstance() {
        if (dm == null) dm = new DatabaseManager();
        return dm;
    }
}
