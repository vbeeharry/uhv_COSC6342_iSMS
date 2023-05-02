package com.uhv.cosc6342.isms.utils;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadAFile {
 
    private String fileName;
    private File file;
    private FileReader fr;
    private BufferedReader br;

    private boolean fileExists;

    private String line;

    /**
     * Constructor
     */
    public ReadAFile (String fileName) {
        this.fileName = fileName;
    }

    /**
     * read
     */
    public void read() {
        try {
            file = new File(fileName);
            fileExists = file.exists();

            if (fileExists) {
                fr = new FileReader(file);
                br = new BufferedReader(fr);
                System.out.println("\n");
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                System.out.println("\n\n");
                br.close();
                fr.close();
            }
            else {
                System.out.println("No syllabus added for course yet.");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
