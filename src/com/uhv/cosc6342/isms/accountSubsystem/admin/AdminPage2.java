/**
 * AdminPage2.java
 */

package com.uhv.cosc6342.isms.accountSubsystem.admin;

import com.uhv.cosc6342.isms.controller.UIInterface;

public class AdminPage2 extends UIInterface {

    /**
     * Init
     */
    protected void init() {
        title = "Admin";
        options = new String[6];
        options[0] = new String("Exit");
        options[1] = new String("Go back");
        options[2] = new String("View all Professors Profile");
        options[3] = new String("View a Professor Profile");
        options[4] = new String("Add Professor Profile");
        options[5] = new String("Remove Professor Profile");
    }
}
