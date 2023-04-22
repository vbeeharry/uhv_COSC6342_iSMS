package com.uhv.cosc6342.isms;

import com.uhv.cosc6342.isms.ui.UserInterface;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.Debug;

/**
 * For the iSMS project.
 */
public class Main {

    private Debug debug;
    private CsvReaderUser cr;
    private UserInterface ui;
    
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
    }

    /**
     * Init
     */
    private void init() {
        debug = Debug.getInstance(); debug.setEnabled();
        cr = new CsvReaderUser("records.csv"); cr.readAll();
        ui = UserInterface.getInstance();
    }
}
