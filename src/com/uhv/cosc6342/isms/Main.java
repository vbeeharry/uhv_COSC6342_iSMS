package com.uhv.cosc6342.isms;

import com.uhv.cosc6342.isms.database.DatabaseManager;
import com.uhv.cosc6342.isms.login.Logger;
import com.uhv.cosc6342.isms.ui.UserInterface;
import com.uhv.cosc6342.isms.utils.Debug;

/**
 * For the iSMS project.
 */
public class Main {

    private Debug debug;
    private DatabaseManager dm;
    private UserInterface ui;
    private Logger logger;
    
    public static void main(String[] args) {
        Main m = new Main();
        m.init();
        m.execute();
    }

    /**
     * Init
     */
    private void init() {
        debug = Debug.getInstance(); debug.setEnabled();
        dm = DatabaseManager.getInstance();
        ui = UserInterface.getInstance();
        logger = Logger.getInstance();
    }

    /**
     * Execute
     */
    private void execute() {
        ui.execute();
    }
}
