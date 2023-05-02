package com.uhv.cosc6342.isms.utils;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;

public class FileChooser {

    private String fileName;
    private String fileType;

    private Scanner inputFile;

    public FileChooser(String fileName, String fileType) { 
        this.fileName = fileName;
        this.fileType = fileType;
    }
    
    public void execute() {
        JFileChooser chooser = new JFileChooser(System.getProperty("java.class.path"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter(fileName, fileType);
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                inputFile= new Scanner(new File(chooser.getSelectedFile().getAbsolutePath()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    } 

    public void display() {
        System.out.println("\n");
        while(inputFile.hasNextLine()) {
            String line = inputFile.next();
            System.out.println(line);
        }
    }
}
