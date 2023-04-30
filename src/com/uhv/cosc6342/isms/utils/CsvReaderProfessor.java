/**
 * CsvReaderStudent.java
 */
package com.uhv.cosc6342.isms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to read csv files
 */
public class CsvReaderProfessor {

    private static CsvReaderProfessor crp = null;

    private String fileName;

    private List userList;
    
    /**
     * Constructor
     */
    private CsvReaderProfessor (String fileName) {
        this.fileName = fileName;
        userList = new ArrayList();
    }

    /**
     * ReadAll
     */
    public List readAll() {
        userList.clear();
        
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String [] tempArr;
            
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                userList.add(tempArr);
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return userList;
    }

    /**
     * Getter for user list
     */
    public List getUserList() {
        return userList;
    }

    /**
     * Get professor by id
     */
    public String getProfessorId(String id) {
        String pId = "NotAssigned";
        readAll();
        
        for (Iterator iter = userList.iterator(); iter.hasNext();) {
            String[] temp = (String[]) iter.next();
            if (temp[3].equals(id)) {
                pId = id;
                break;
            }
        }

        return pId;
    }


    /**
     * Singleton instance
     */
    public static CsvReaderProfessor getInstance(String fileName) {
        if (crp == null) { crp = new CsvReaderProfessor(fileName); }
        return crp;
    }

    /**
     * Return the singleton instance
     */
    public static CsvReaderProfessor getInstance() {
        return crp;
    }
}
