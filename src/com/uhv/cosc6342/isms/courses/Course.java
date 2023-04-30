/**
 * Course.java
 */

package com.uhv.cosc6342.isms.courses;

/**
 * This represents a course object
 */
public class Course {

    private String name;
    private String day;
    private int numOfSeatsTotal;
    private int numOfSeatsTaken;
    private int numOfSeatsAvailable;
    private String id;
    
    /**
     * Constructor
     */
    public Course () {
        init();
    }

    public String getName() {
        return name;
    }

    
}
