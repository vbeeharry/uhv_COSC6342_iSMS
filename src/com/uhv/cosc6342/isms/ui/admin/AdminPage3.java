/**
 * AdminPage3.java
 */

package com.uhv.cosc6342.isms.ui.admin;

import com.uhv.cosc6342.isms.ui.UIInterface;

public class AdminPage3 extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Admin";
        options = new String[6];
        options[0] = new String("Exit");
        options[1] = new String("Go back");
        options[2] = new String("View all Semester Courses");
        options[3] = new String("View a Course info");
        options[4] = new String("Add a Course for the Semester");
        options[5] = new String("Remove a Course for the Semester");
    }
}
