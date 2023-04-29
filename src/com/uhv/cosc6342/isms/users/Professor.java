/**
 * Professor.java
 */

 package com.uhv.cosc6342.isms.users;

 /**
  * Admin class
  */
  public class Professor extends User {

    /**
     * Constructor
     */
    public Professor (String[] temp) {
        super(temp);
        debug.log("New Professor created: " + getFirstName()
            + " " + getLastName());
    }

    /**
     * InitMe
     */
    protected void initMe() { }
  }