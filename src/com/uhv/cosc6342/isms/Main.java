package com.uhv.cosc6342.isms;

import com.uhv.cosc6342.isms.ui.Entry;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.Debug;

/**
 * For the iSMS project.
 */
public class Main {

    private Entry entry;
    private CsvReaderUser cr;
    private Debug debug;
    
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
        debug = Debug.getInstance();
        debug.setEnabled();
        entry = new Entry();
        cr = new CsvReaderUser("records.csv");
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
