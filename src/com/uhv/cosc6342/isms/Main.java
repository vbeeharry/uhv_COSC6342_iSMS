package com.uhv.cosc6342.isms;

import com.uhv.cosc6342.isms.ui.Entry;

/**
 * For the iSMS project.
 */
public class Main {

    private Entry entry;
    
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
    }

    /**
     * Display
     */
    private void display() {
        entry.display();
    }

    /**
     * Execute
     */
    private void execute() {
        while (true) { }
    }
}
