/**
 * Course.java
 */

package com.uhv.cosc6342.isms.courses;

import com.uhv.cosc6342.isms.users.Professor;
import com.uhv.cosc6342.isms.utils.CsvReaderProfessor;

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
    private String instructionMode;
    private String room;
    private String startDate;
    private String endDate;
    private String professorId;

    private CsvReaderProfessor crp;

    /**
     * Constructor
     */
    public Course () { }

    /**
     * Constructor
     */
    public Course (String[] temp) {
        crp = CsvReaderProfessor.getInstance();
        this.id = temp[0];
        this.name = temp[1];
        this.day = temp[2];
        this.numOfSeatsTotal = Integer.parseInt(temp[3]);
        this.numOfSeatsTaken = Integer.parseInt(temp[4]);
        this.numOfSeatsAvailable = numOfSeatsTotal - numOfSeatsTaken;
        this.instructionMode = temp[5];
        this.room = temp[6];
        this.startDate = temp[7];
        this.endDate = temp[8];
        this.professorId = crp.getProfessorId(temp[9]);
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

    public String getInstructionMode() {
        return instructionMode;
    }
    
    public String getRoom() {
        return room;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getId() {
        return id;
    }

    public String getProfessorId() {
        return professorId;
    }
}
