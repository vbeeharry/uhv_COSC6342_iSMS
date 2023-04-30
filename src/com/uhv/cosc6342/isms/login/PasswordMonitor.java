/**
 * PasswordManager.java
 */

package com.uhv.cosc6342.isms.login;

/**
 * This class controls the password for the screen.
 */
public class PasswordMonitor {

    private static PasswordMonitor pm = null;
    
    private PasswordGenerator pg;  

    /**
     * Constructor
     */
    private PasswordMonitor () { 
        init();
    }

    /**
     * Init
     */
    private void init() {            
        pg = PasswordGenerator.getInstance();
    }

    /**
     * Validate
     */
    public boolean validate(String strFromFile, String strFromScreen) {
        boolean result = false;

        if (strFromFile.equals(pg.createPassword(strFromScreen))) {
            result = true;
        }

        return result;
    }
    
    /**
     * Creates a Singleton Instance
     */
    public static PasswordMonitor getInstance() {
        if (pm == null) { pm = new PasswordMonitor(); }
        return pm;
    }
}
