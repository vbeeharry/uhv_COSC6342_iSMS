/**
 * Entry.java
 */

package com.uhv.cosc6342.isms.ui;

public class EntryPage extends UIInterface {

    /**
     * Constructor
     */
    public EntryPage () {
        init();
    }

    /**
     * Init
     */
    private void init() { 
        title = "Welcome to ISMS Portal";
        options = new String[2];
        options[0] = new String("Exit");
        options[1] = new String("Sign In");
    }
}
