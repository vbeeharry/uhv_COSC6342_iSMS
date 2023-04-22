/**
 * AdminPage0.java
 */

package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

/**
 * Main Admin page
 */
public class AdminPage0 extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin"; //lm.getActiveUser().toString();
        options = new String[3];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Manage Students");
        options[2] = new String("Manage Professors");
    }
}
