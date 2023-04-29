/**
 * Student.java
 */

 package com.uhv.cosc6342.isms.users;

 /**
  * Student class
  */
  public class Student extends User {

    private float gpa = Float.NaN;
    
    /**
     * Constructor
     */
    public Student (String[] temp) {
        super(temp);
        debug.log("New Student created: " + getFirstName()
            + " " + getLastName());
    }

    /**
     * InitMe()
     */
    @Override
    protected void initMe() { }

    /**
     * Get GPA
     */
    public float getGpa() {
      return gpa;
    }
  }