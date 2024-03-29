/**
 * CsvReaderStudent.java
 */
package com.uhv.cosc6342.isms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read csv files
 */
public class CsvReaderStudent {

    private static CsvReaderStudent crs = null;

    private String fileName;

    private List userList;
    
    /**
     * Constructor
     */
    private CsvReaderStudent(String fileName) {
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
     * Singleton instance
     */
    public static CsvReaderStudent getInstance(String fileName) {
        if (crs == null) { crs = new CsvReaderStudent(fileName); }
        return crs;
    }

    /**
     * Return the singleton instance
     */
    public static CsvReaderStudent getInstance() {
        return crs;
    }
}
