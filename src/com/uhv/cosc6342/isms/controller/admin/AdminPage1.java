/**
 * AdminPage1.java
 */

package com.uhv.cosc6342.isms.controller.admin;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class AdminPage1 extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Admin";
        options = new String[6];
        options[0] = new String("Exit");
        options[1] = new String("Go back");
        options[2] = new String("View all Students Profile");
        options[3] = new String("View a Student Profile");
        options[4] = new String("Add Student Profile");
        options[5] = new String("Remove Student Profile");
    }
}
