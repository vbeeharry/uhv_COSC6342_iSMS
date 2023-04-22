/**
 * Student.java
 */

 package com.uhv.cosc6342.isms.users;

 /**
  * Admin class
  */
  public class Student extends User {

    /**
     * Constructor
     */
    public Student (String[] temp) {
        super(temp);
        debug.log("New Student created: " + getFirstName()
            + " " + getLastName());
    }
  }