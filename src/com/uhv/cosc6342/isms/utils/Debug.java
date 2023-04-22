package com.uhv.cosc6342.isms.utils;

public class Debug {
    
    private static Debug debug = null;
    private boolean enabled = false;

    /**
     * Constructor
     */
    private Debug () { }

    /**
     * Set enabled
     */
    public void setEnabled() {
        enabled = true;
    }

    /**
    * Logging
    */
    public void log(String str) {
        if (enabled) { System.out.println(str); }
    }
    
    /**
     * Singleton instance
     */
    public static Debug getInstance() {
        if (debug == null) {
            debug = new Debug(); 
        }

        return debug;
    }
}
