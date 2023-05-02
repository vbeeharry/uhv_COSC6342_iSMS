/**
 * CsvReaderCourse.java
 */
 package com.uhv.cosc6342.isms.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uhv.cosc6342.isms.courseSubsystem.Course;

/**
 * Class to read csv files
 */
public class CsvReaderCourse {

    private static CsvReaderCourse crc = null;

    private String fileName;

    private List courseList;
    
    /**
     * Constructor
     */
    private CsvReaderCourse(String fileName) {
        this.fileName = fileName;
        courseList = new ArrayList();
    }

    /**
     * ReadAll
     */
    public List readAll() {
        courseList.clear();
                
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String [] tempArr;
            
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                courseList.add(new Course(tempArr));
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return courseList;
    }

    /**
     * Getter for user list
     */
    public List getCourseList() {
        return courseList;
    }


    /**
     * Singleton instance
     */
    public static CsvReaderCourse getInstance(String fileName) {
        if (crc == null) { crc = new CsvReaderCourse(fileName); }
        return crc;
    }

    /**
     * Return the singleton instance
     */
    public static CsvReaderCourse getInstance() {
        return crc;
    }
}
