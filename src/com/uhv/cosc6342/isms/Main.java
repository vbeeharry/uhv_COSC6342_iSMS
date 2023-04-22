package com.uhv.cosc6342.isms;

import com.uhv.cosc6342.isms.ui.Entry;
import com.uhv.cosc6342.isms.util.CsvReader;;

/**
 * For the iSMS project.
 */
public class Main {

    private Entry entry;
    private CsvReader cr;
    
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.display();
        m.execute();
    }

    /**
     * Init
     */
    private void init() {
        entry = new Entry();
        cr = new CsvReader("records.csv");
    }

    /**
     * Display
     */
    private void display() {
        entry.display();
        cr.readAll();
    }

    /**
     * Execute
     */
    private void execute() {

    }
}
