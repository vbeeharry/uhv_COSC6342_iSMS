package com.uhv.cosc6342.isms.databaseSubsystem;

import com.uhv.cosc6342.isms.courseSubsystem.Course;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Admin;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Professor;
import com.uhv.cosc6342.isms.enrolmentSubsystem.Student;
import com.uhv.cosc6342.isms.enrolmentSubsystem.User;
import com.uhv.cosc6342.isms.loginSubsystem.PasswordGenerator;
import com.uhv.cosc6342.isms.utils.Constants;
import com.uhv.cosc6342.isms.utils.CsvReaderCourse;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;
import com.uhv.cosc6342.isms.utils.CsvReaderProfessor;
import com.uhv.cosc6342.isms.utils.CsvReaderStudent;
import com.uhv.cosc6342.isms.utils.CsvReaderStudentCourse;
import com.uhv.cosc6342.isms.utils.CsvWriter;
import com.uhv.cosc6342.isms.utils.Debug;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class DatabaseManager implements Constants {

    public static DatabaseManager dm = null;

    private CsvReaderUser cru;
    private CsvReaderProfessor crp;
    private CsvReaderStudent crs;
    private CsvReaderCourse crc;
    private CsvReaderStudentCourse crsc;
    private CsvWriter cw;

    private Debug debug;

    private PasswordGenerator pg;

    /**
     * Private constructor
     */
    private DatabaseManager() { 
        init();
    }

    /**
     * init
     */
    public void init() {
        debug = Debug.getInstance();
        pg = PasswordGenerator.getInstance();
        cru = CsvReaderUser.getInstance(USERS_FILE); cru.readAll();
        crp = CsvReaderProfessor.getInstance(PROFESSORS_FILE); crp.readAll();
        crs = CsvReaderStudent.getInstance(STUDENTS_FILE); crs.readAll();
        crc = CsvReaderCourse.getInstance(COURSES_FILE); crc.readAll();
        crsc = CsvReaderStudentCourse.getInstance(STUDENT_COURSE_FILE); crsc.readAll();
        cw = CsvWriter.getInstance();

        try {
            debug.log("Checking Admins File");
            File adminsFile = new File(ADMINS_FILE);
            if (!adminsFile.exists()) {
                adminsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            debug.log("Checking Professors File");
            File professorsFile = new File(PROFESSORS_FILE);
            if (!professorsFile.exists()) {
                professorsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            debug.log("Checking Students File");
            File studentsFile = new File(STUDENTS_FILE);
            if (!studentsFile.exists()) {
                studentsFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            debug.log("Checking Courses File");
            File coursesFile = new File(COURSES_FILE);
            if (!coursesFile.exists()) {
                coursesFile.createNewFile();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        writeToAdminsFile();
        writeToProfessorsFile();
        writeToStudentsFile();
    }

    /**
     * Write to admins file
     */
    public void writeToAdminsFile() {
        try {
            FileWriter fw = new FileWriter(ADMINS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cru.getAdminList().iterator(); iter.hasNext();) {
                Admin temp = (Admin) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + "\n");
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Write to professors file
     */
    public void writeToProfessorsFile() {
        try {
            FileWriter fw = new FileWriter(PROFESSORS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cru.getProfessorList().iterator(); iter.hasNext();) {
                Professor temp = (Professor) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + "\n");
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to students file
     */
    public void writeToStudentsFile() {
        try {
            FileWriter fw = new FileWriter(STUDENTS_FILE);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (Iterator iter = cru.getStudentList().iterator(); iter.hasNext();) {
                Student temp = (Student) iter.next();
                bw.write(temp.getFirstName() + "," 
                    + temp.getLastName() + ","
                    + temp.getEmail() + ","
                    + temp.getUserId() + ","
                    + temp.getGpa() + "\n") ;
            }

            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to user file
     */
    private void writeToUserFile(User user, String role) {
        try {
            FileWriter fw = new FileWriter(USERS_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(user.getFirstName() + "," 
                    + user.getLastName() + ","
                    + user.getEmail() + ","
                    + user.getUserId() + ","
                    + pg.createPassword(user.getPassword()) + ","
                    + role + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Write to student file
     */
    private void writeToStudentFile(Student student) {
        try {
            FileWriter fw = new FileWriter(STUDENTS_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(student.getFirstName() + "," 
                    + student.getLastName() + ","
                    + student.getEmail() + ","
                    + student.getUserId() + ","
                    + student.getGpa() + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Add a student to the school database
     */
    public void addStudent(String[] temp) {
        debug.log("Adding a new student");

        boolean okToAdd = checkIfIdExists(cru, temp);
        if (okToAdd) {
            Student tempStudent = new Student(temp);
            writeToUserFile(tempStudent, "student");
            writeToStudentFile(tempStudent);
        }
        else {
            System.out.println("Unable to add Student. User ID Already exists.");
        }
    }

    /**
     * Check if user id already exists
     */
    private boolean checkIfIdExists(CsvReaderUser cru, String[] temp) {
        boolean result = true;
        List user = cru.getUserList();

        for (Iterator iter = user.iterator(); iter.hasNext();) {
            User tempUser = (User) iter.next();
            if (tempUser.getUserId().equals(temp[3])) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Delete a student from the school database
     */
    public void deleteStudent(String id) {
        int studentIndex = okToDeleteStudent(id);

        if (studentIndex != -1) {
            deleteFromStudentsFile(studentIndex);     
            deleteFromUsersFile(id);     
        }
        else {
            debug.log("Student ID not found. No Student deleted");
        }
    }

    /**
     * Check if ok to delete
     */
    private int okToDeleteStudent(String id) {
        int result = -1;
        List student = crs.getUserList();

        int i = 0;
        for (Iterator iter = student.iterator(); iter.hasNext();) {
            String[] tempStudent = (String[]) iter.next();
            if (tempStudent[3].equals(id)) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }

    /**
     * Delete frrom students file
     */
    private void deleteFromStudentsFile(int index) {
        List students = crs.getUserList();
        students.remove(index);

        List temp = students;

        try {
            File file = new File(STUDENTS_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllStudents(STUDENTS_FILE, temp);
        debug.log("Student Profile has been deleted");
    }

    /**
     * Delete from users file
     */
    private void deleteFromUsersFile(String id) {
        int index = -1;
        cru.updateUsers();
        List users = cru.getUserList();

        int i = 0;
        for (Iterator iter = users.iterator(); iter.hasNext();) {
            User tempUser = (User) iter.next();
            if (tempUser.getUserId().equals(id)) {
                index = i;
                break;
            }
            i++;
        }

        users.remove(index);
        List temp = users;

        try {
            File file = new File(USERS_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllUsers(USERS_FILE, temp);
    }

    /**
     * Add a professor to the school database
     */
    public void addProfessor(String[] temp) {
        debug.log("Adding a new professor");

        boolean okToAdd = checkIfIdExists(cru, temp);
        if (okToAdd) {
            Professor tempProfessor = new Professor(temp);
            writeToUserFile(tempProfessor, "professor");
            writeToProfessorsFile(tempProfessor);
        }
        else {
            System.out.println("Unable to add Professor. User ID Already exists.");
        }
    }

    /**
     * Write to professor file
     */
    private void writeToProfessorsFile(Professor professor) {
        try {
            FileWriter fw = new FileWriter(PROFESSORS_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(professor.getFirstName() + "," 
                    + professor.getLastName() + ","
                    + professor.getEmail() + ","
                    + professor.getUserId() + "\n");
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Delete a professor from the school database
     */
    public void deleteProfessor(String id) {
        int professorIndex = okToDeleteProfessor(id);

        if (professorIndex != -1) {
            deleteFromProfessorsFile(professorIndex);     
            deleteFromUsersFile(id);     
        }
        else {
            debug.log("Professor ID not found. No Professor deleted.");
        }
    }

    /**
     * Check if ok to delete
     */
    private int okToDeleteProfessor(String id) {
        int result = -1;
        List professor = crp.getUserList();

        int i = 0;
        for (Iterator iter = professor.iterator(); iter.hasNext();) {
            String[] tempProfessor = (String[]) iter.next();
            if (tempProfessor[3].equals(id)) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }

    /**
     * Delete frrom professor file
     */
    private void deleteFromProfessorsFile(int index) {
        List professors = crp.getUserList();
        professors.remove(index);

        List temp = professors;

        try {
            File file = new File(PROFESSORS_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllProfessors(PROFESSORS_FILE, temp);
        debug.log("Professor Profile has been deleted");
    }

    /**
     * Add a course for the semester
     */
    public void addCourse(String[] temp) {
        debug.log("Adding a new course");

        boolean okToAdd = checkIfCourseIdExists(crc, temp);
        if (okToAdd) {
            Course course = new Course(temp);
            writeToCourseFile(course);
        }
        else {
            System.out.println("Unable to add Course. Course ID Already exists.");
        }
    }

    /**
     * Check if course id already exists
     */
    private boolean checkIfCourseIdExists(CsvReaderCourse crc, String[] temp) {
        boolean result = true;
        List course = crc.getCourseList();

        for (Iterator iter = course.iterator(); iter.hasNext();) {
            Course tempCourse = (Course) iter.next();
            if (tempCourse.getCourseID().equals(temp[0])) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Write to course file
     */
    private void writeToCourseFile(Course course) {
        try {
            FileWriter fw = new FileWriter(COURSES_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String str = course.getCourseID() + ","
                + course.getName() + ","
                + course.getDay() + ","
                + course.getNumOfSeatsTotal() + ","
                + course.getNumOfSeatsTaken() + ","
                + course.getInstructionMode() + ","
                + course.getRoom() + ","
                + course.getStartDate() + ","
                + course.getEndDate() + ",";
            
            String professorId = course.getProfessorId();
            String pId = crp.getProfessorId(professorId);
            str = str + pId + "\n";
            
            bw.write(str);
            bw.flush();
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    /**
     * Delete a course from the school database
     */
    public void deleteCourse(String id) {
        int courseIndex = okToDeleteCourse(id);

        if (courseIndex != -1) {
            deleteFromCoursesFile(courseIndex);     
        }
        else {
            debug.log("Course ID not found. No Course deleted.");
        }
    }

    /**
     * Check if ok to delete
     */
    private int okToDeleteCourse(String id) {
        int result = -1;
        List course = crc.getCourseList();

        int i = 0;
        for (Iterator iter = course.iterator(); iter.hasNext();) {
            Course tempCourse = (Course) iter.next();
            if (tempCourse.getCourseID().equals(id)) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }

    /**
     * Delete frrom courses file
     */
    private void deleteFromCoursesFile(int index) {
        crc.readAll();
        List courses = crc.getCourseList();
        courses.remove(index);

        List temp = courses;

        try {
            File file = new File(COURSES_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllCourses(COURSES_FILE, temp);
        debug.log("Course has been deleted");
    }

    /**
     * Add a course to a student
     */
    public void addStudentCourse(Student student, Course course) {
        boolean okToAdd = checkIfStudentCourseIdExists(student, course)
            && seatsAvailable(course);

        if (okToAdd) {
            writeToStudentCourseFile(student, course);
            debug.log("\nCourse has been registere.");
        }
        else {
            System.out.println("Course has not been registered.");
        }
    }

    /**
     * Check if student course alreaadu registered
     */
    private boolean checkIfStudentCourseIdExists(Student student, Course course) {
        crsc.readAll();

        boolean result = true;
        List studentCourseList = crsc.getStudentCourseList();

        int i = 0;
        for (Iterator iter = studentCourseList.iterator(); iter.hasNext();) {
            String[] temp = (String[]) iter.next();
            if (student.getUserId().equals(temp[0]) 
                && course.getCourseID().equals(temp[1])) {
                result = false;
                break;
            }
        }

        return result;
    }

    /**
     * Check seats available
     */
    private boolean seatsAvailable(Course course) {
        boolean result = true;

        if (course.getNumOfAvailableSeats() <= 0) {
            result = false;
            System.out.println("No seats available for this course.");
        }

        return result;
    }

    /**
     * Write to course file
     */
    private void writeToStudentCourseFile(Student student, Course course) {
        try {
            FileWriter fw = new FileWriter(STUDENT_COURSE_FILE, true);
            BufferedWriter bw = new BufferedWriter(fw);
            String str = student.getUserId() + "," + course.getCourseID() + "\n";           
            bw.write(str);
            bw.flush();
            bw.close();

            updateCourseSeating(course);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * updateCourseSeating
     */
    private void updateCourseSeating(Course course) {
       // crc.readAll();
       List courseList = crc.getCourseList();

        for (Iterator iter = courseList.iterator(); iter.hasNext();) {
            Course temp = (Course) iter.next();
            if (temp.getCourseID().equals(course.getCourseID())) {
                temp.incrementSeatsTaken();
                break;
            }
        }

        List newCourseList = courseList;
        try {
            File file = new File(COURSES_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllCourses(COURSES_FILE, newCourseList);
    }

    /**
     * Drop a course for a student
     */
    public void dropStudentCourse(Student student, Course course) {
        int courseIndex = okToDeleteStudentCourse(student, course);

        if (courseIndex != -1) {
            deleteFromStudentCourseFile(courseIndex);     
        }
        else {
            debug.log("Course ID not found. No Course deleted.");
        }
    }

     /**
     * Check if ok to delete
     */
    private int okToDeleteStudentCourse(Student student, Course course) {
        int result = -1;
        List studentCourseList = crsc.getStudentCourseList();

        int i = 0;
        for (Iterator iter = studentCourseList.iterator(); iter.hasNext();) {
            String[] temp = (String[]) iter.next();
            if (temp[0].equals(student.getUserId()) && temp[1].equals(course.getCourseID())) {
                result = i;
                break;
            }
            i++;
        }

        return result;
    }
    
    /**
     * Delete frrom student course file
     */
    private void deleteFromStudentCourseFile(int index) {
        crsc.readAll();
        List studentCourseList = crsc.getStudentCourseList();
        studentCourseList.remove(index);

        List temp = studentCourseList;

        try {
            File file = new File(STUDENT_COURSE_FILE);
            FileWriter fw = new FileWriter(file, false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        cw.writeAllStudentCourse(STUDENT_COURSE_FILE, temp);
        debug.log("Course has been deleted");
    }

    /**
     * Singleton instance
     */
    public static DatabaseManager getInstance() {
        if (dm == null) dm = new DatabaseManager();
        return dm;
    }
}
