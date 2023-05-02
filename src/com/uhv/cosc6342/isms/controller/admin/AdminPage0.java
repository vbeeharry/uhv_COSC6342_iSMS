/**
 * AdminPage0.java
 */

package com.uhv.cosc6342.isms.controller.admin;

import com.uhv.cosc6342.isms.controller.UIInterface;

/**
 * Main Admin page
 */
public class AdminPage0 extends UIInterface {
    
    /**
     * Init
     */
    protected void init() {
        title = "Admin"; //lm.getActiveUser().toString();
        options = new String[4];
        options[0] = new String("Log out and Exit");
        options[1] = new String("Manage Students");
        options[2] = new String("Manage Professors");
        options[3] = new String("Manage Courses");
    }
}
