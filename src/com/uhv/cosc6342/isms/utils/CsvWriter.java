package com.uhv.cosc6342.isms.utils;

import com.uhv.cosc6342.isms.users.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class CsvWriter {

    public static CsvWriter cw = null;

    /**
     * Constructor
     */
    private CsvWriter () {  }

    /**
     * Write to a csv file
     */
    public void writeAllUsers(String fileName, List data) {
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Iterator iter = data.iterator(); iter.hasNext();) {
                User temp = (User) iter.next();
                String str = temp.getFirstName() + "," + temp.getLastName() + ","
                    + temp.getEmail() + "," + temp.getUserId() + ","
                    + temp.getPassword() + "," + temp.getRole() + "\n";
                bw.write(str);
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to a csv file
     */
    public void writeAllStudents(String fileName, List data) {
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Iterator iter = data.iterator(); iter.hasNext();) {
                String[] temp = (String[]) iter.next();
                bw.write(temp[0] + "," + temp[1] + "," + temp[2] + ","
                    + temp[3] + "," + temp[4] + "\n");
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Singleton Instance
     */
    public static CsvWriter getInstance() {
        if (cw == null) { cw = new CsvWriter(); }
        return cw;
    }
    
}