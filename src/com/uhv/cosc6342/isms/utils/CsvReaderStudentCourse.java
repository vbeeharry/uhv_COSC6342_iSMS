/**
 * CsvReaderCourse.java
 */
 package com.uhv.cosc6342.isms.utils;

import com.uhv.cosc6342.isms.courses.Course;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read csv files
 */
public class CsvReaderStudentCourse {

    private static CsvReaderStudentCourse crsc = null;

    private String fileName;

    private List studentCourseList;
    
    /**
     * Constructor
     */
    private CsvReaderStudentCourse(String fileName) {
        this.fileName = fileName;
        studentCourseList = new ArrayList();
    }

    /**
     * ReadAll
     */
    public List readAll() {
        studentCourseList.clear();
                
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String [] tempArr;
            
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                studentCourseList.add(tempArr);
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return studentCourseList;
    }

    /**
     * Getter for studentCourseList
     */
    public List getStudentCourseList() {
        return studentCourseList;
    }

    /**
     * Singleton instance
     */
    public static CsvReaderStudentCourse getInstance(String fileName) {
        if (crsc == null) { crsc = new CsvReaderStudentCourse(fileName); }
        return crsc;
    }

    /**
     * Return the singleton instance
     */
    public static CsvReaderStudentCourse getInstance() {
        return crsc;
    }
}
