/**
 * Admin.java
 */

 package com.uhv.cosc6342.isms.users;


 /**
  * Admin class
  */
  public class Admin extends User {

    /**
     * Constructor
     */
    public Admin (String[] temp) {
        super(temp);
        debug.log("New Admin created: " + getFirstName()
            + " " + getLastName());
    }
  }