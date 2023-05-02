/**
 * CsvReaderUser.java
 */
package com.uhv.cosc6342.isms.utils;

import com.uhv.cosc6342.isms.accountSubsystem.Admin;
import com.uhv.cosc6342.isms.accountSubsystem.Professor;
import com.uhv.cosc6342.isms.accountSubsystem.Student;
import com.uhv.cosc6342.isms.accountSubsystem.User;
import com.uhv.cosc6342.isms.utils.Debug;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read csv files
 */
public class CsvReaderUser implements Constants {

    private static CsvReaderUser cru = null;

    private String fileName;
    private List userList;
    private List adminList;
    private List professorList;
    private List studentList;
    private Debug debug = Debug.getInstance();
    
    /**
     * Constructor
     */
    private CsvReaderUser(String fileName) {
        this.fileName = fileName;
        userList = new ArrayList<User>();
        adminList = new ArrayList<Admin>();
        professorList = new ArrayList<Professor>();
        studentList = new ArrayList<Student>();
    }

    /**
     * ReadAll
     */
    public void readAll() {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String [] tempArr;
            
            debug.log("##### Records lookup: #####");
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                String role = tempArr[5];
                if (role.equalsIgnoreCase("Admin")) {
                    User u = new Admin(tempArr);
                    userList.add(u);
                    adminList.add((Admin) u);
                }
                else if (role.equalsIgnoreCase("Professor")) {
                    User u = new Professor(tempArr);
                    userList.add(u);
                    professorList.add((Professor) u);
                } 
                else if (role.equalsIgnoreCase("Student")) {
                    User u = new Student(tempArr);
                    userList.add(u);
                    studentList.add((Student) u);
                }
            }
            br.close();
            System.out.println("\n\n\n\n\n");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Update Users
     */
    public void updateUsers() {
        userList.clear();

        try {
            File file = new File(USERS_FILE);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String [] tempArr;
            
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                String role = tempArr[5];
                if (role.equalsIgnoreCase("Admin")) {
                    User u = new Admin(tempArr);
                    userList.add(u);
                    adminList.add((Admin) u);
                }
                else if (role.equalsIgnoreCase("Professor")) {
                    User u = new Professor(tempArr);
                    userList.add(u);
                } 
                else if (role.equalsIgnoreCase("Student")) {
                    User u = new Student(tempArr);
                    userList.add(u);
                }
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Getter for user list
     */
    public List getUserList() {
        return userList;
    }

    /**
     * Getter for the admin list
     */
    public List getAdminList() {
        return adminList;
    }

    /**
     * Getter for Professor list
     */
    public List getProfessorList() {
        return professorList;
    }

    /**
     * Getter for Student list
     */
    public List getStudentList() {
        return studentList;
    }

    /**
     * Singleton instance
     */
    public static CsvReaderUser getInstance(String fileName) {
        if (cru == null) { cru = new CsvReaderUser(fileName); }
        return cru;
    }

    /**
     * Return the singleton instance
     */
    public static CsvReaderUser getInstance() {
        return cru;
    }
}
