/**
 * CsvReader.java
 */

package com.uhv.cosc6342.isms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class to read csv files
 */
public class CsvReader {

    private String fileName;
    
    /**
     * Constructor
     */
    public CsvReader(String fileName) {
        this.fileName = fileName;
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
            
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                for (String tempStr : tempArr) {
                    System.out.println(tempStr + " ");
                }
                System.out.println();
            }
            br.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
