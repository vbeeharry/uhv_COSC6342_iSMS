/**
 * Course.java
 */

package com.uhv.cosc6342.isms.courseSubsystem;

import com.uhv.cosc6342.isms.enrolmentSubsystem.Professor;
import com.uhv.cosc6342.isms.utils.CsvReaderProfessor;

import java.io.File;

/**
 * This represents a course object
 */
public class Course {

    private String id;
    private String name;
    private String day;
    private String numOfSeatsTotal;
    private String numOfSeatsTaken;
    private String numOfSeatsAvailable;
    private String instructionMode;
    private String room;
    private String startDate;
    private String endDate;
    private String professorId;
    private String syllabusAdded;

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
        this.numOfSeatsTotal = temp[3];
        this.numOfSeatsTaken = temp[4];
        this.numOfSeatsAvailable = temp[5];
        this.instructionMode = temp[6];
        this.room = temp[7];
        this.startDate = temp[8];
        this.endDate = temp[9];
        this.professorId = crp.getProfessorId(temp[10]);

        File syllabusFile = new File(id + "_syllabus.syl");
        this.syllabusAdded = syllabusFile.exists() ? "Yes" : "No";
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }

    public String getNumOfSeatsTotal() {
        return numOfSeatsTotal;
    }

    public String getNumOfSeatsTaken() {
        return numOfSeatsTaken;
    }

    public String getNumOfAvailableSeats() {
        numOfSeatsAvailable = Integer.toString(
                Integer.parseInt(numOfSeatsTotal) - Integer.parseInt(numOfSeatsTaken));
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

    public String getCourseID() {
        return id;
    }

    public String getProfessorId() {
        return professorId;
    }

    public String getSyllabusAdded() {
        return syllabusAdded;
    }

    public void setSyllabusAdded(boolean value) {
        syllabusAdded = value ? "Yes" : "No";
    }

    public void incrementSeatsTaken() {
        numOfSeatsTaken = Integer.toString(Integer.parseInt(numOfSeatsTaken) + 1);
    }
}
