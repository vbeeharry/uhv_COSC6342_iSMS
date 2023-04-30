package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPageDeleteProfessor extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin - Delete Professor Profile";
    }

    /**
     * Delete the Professor
     */
    public void deleteProfessor() {
        List temp = crp.readAll();

        System.out.println("\n");
        displayTitle();

        System.out.println("Enter Professor User ID:");
        Scanner in = new Scanner(System.in);
        String id = in.next();

        dm.deleteProfessor(id);
    }
}
