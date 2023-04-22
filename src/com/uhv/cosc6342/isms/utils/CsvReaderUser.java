/**
 * CsvReader.java
 */
package com.uhv.cosc6342.isms.utils;

import com.uhv.cosc6342.isms.users.Admin;
import com.uhv.cosc6342.isms.users.Professor;
import com.uhv.cosc6342.isms.users.Student;
import com.uhv.cosc6342.isms.utils.Debug;
import com.uhv.cosc6342.isms.utils.SharedObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read csv files
 */
public class CsvReaderUser {

    private String fileName;
    private List userList;
    private Debug debug = Debug.getInstance();
    private SharedObject sharedObject = SharedObject.getInstance();
    
    /**
     * Constructor
     */
    public CsvReaderUser(String fileName) {
        this.fileName = fileName;
        userList = new ArrayList();
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
                    userList.add(new Admin(tempArr));
                }
                else if (role.equalsIgnoreCase("Professor")) {
                    userList.add(new Professor(tempArr));
                } 
                else if (role.equalsIgnoreCase("Student")) {
                    userList.add(new Student(tempArr));
                }
            }
            br.close();
            sharedObject.putObject("userList", userList);
            System.out.println("\n\n\n\n\n");
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
