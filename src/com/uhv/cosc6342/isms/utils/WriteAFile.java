package com.uhv.cosc6342.isms.utils;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class WriteAFile {

    private String fileName;
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;

    /**
     * Constructor
     */
    public WriteAFile (String fileName) {
        this.fileName = fileName;
        try {
            file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }
             
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void write(String line) {
        try {
            bw.write(line);
            bw.newLine();
            bw.flush();
            //bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void close() {
        try {
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
