/**
 * Course.java
 */

package com.uhv.cosc6342.isms.courses;

/**
 * This represents a course object
 */
public class Course {

    private String id;
    private String name;
    private String day;
    private int numOfSeatsTotal;
    private int numOfSeatsTaken;
    private int numOfSeatsAvailable;
    
    /**
     * Constructor
     */
    public Course () { }

    /**
     * Constructor
     */
    public Course (String[] temp) {
        this.id = temp[0];
        this.name = temp[1];
        this.day = temp[2];
        this.numOfSeatsTotal = Integer.parseInt(temp[3]);
        this.numOfSeatsTaken = Integer.parseInt(temp[4]);
        this.numOfSeatsAvailable = numOfSeatsTotal - numOfSeatsTaken;
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public int getNumOfSeatsTotal() {
        return numOfSeatsTotal;
    }

    public int getNumOfSeatsTaken() {
        return numOfSeatsTaken;
    }

    public int getNumOfSeatsAvailable() {
        numOfSeatsAvailable = numOfSeatsTotal - numOfSeatsTaken;
        return numOfSeatsAvailable;
    }
    
    public String getId() {
        return id;
    }
}
