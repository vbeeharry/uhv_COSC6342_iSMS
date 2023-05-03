package com.uhv.cosc6342.isms.controller;

import com.uhv.cosc6342.isms.accountSubsystem.admin.*;
import com.uhv.cosc6342.isms.accountSubsystem.professor.*;
import com.uhv.cosc6342.isms.accountSubsystem.student.*;
import com.uhv.cosc6342.isms.enrolmentSubsystem.User;
import com.uhv.cosc6342.isms.loginSubsystem.LoginManagement;

/**
 * This is the UI Manager
 */
public class UserInterface {
    
    public static UserInterface ui = null;

    private LoginManagement lm;

    private User activeUser = null;

    private EntryPage entryPage;
    private SignInPage signInPage;

    /** Admin Accounts */
    private AdminPage0 adminPage0;
    private AdminPage1 adminPage1;
    private AdminPage2 adminPage2;
    private AdminPage3 adminPage3;
    private AdminPageViewStudents adminPageViewStudents;
    private AdminPageViewStudent adminPageViewStudent;
    private AdminPageAddStudent adminPageAddStudent;
    private AdminPageDeleteStudent adminPageDeleteStudent;
    private AdminPageViewProfessors adminPageViewProfessors;
    private AdminPageViewProfessor adminPageViewProfessor;
    private AdminPageAddProfessor adminPageAddProfessor;
    private AdminPageDeleteProfessor adminPageDeleteProfessor;
    private AdminPageViewCourses adminPageViewCourses;
    private AdminPageViewCourse adminPageViewCourse;
    private AdminPageAddCourse adminPageAddCourse;
    private AdminPageDeleteCourse adminPageDeleteCourse;

    /** Professor Accounts */
    private ProfessorPage0 professorPage0;
    private ProfessorViewMyCourses professorViewMyCourses;
    private ProfessorViewMyCourse professorViewMyCourse;
    private ProfessorPageViewMyCourse professorPageViewMyCourse;
    private ProfessorViewStudents professorViewStudents;
    private ProfessorAddSyllabus professorAddSyllabus;
    private ProfessorGradeStudent professorGradeStudent;

    /** Student Accounts */
    private StudentPage0 studentPage0;
    private StudentRegisterForCourse studentRegisterForCourse;
    private StudentViewAvailableCourses studentViewAvailableCourses;
    private StudentViewMyCourses studentViewMyCourses;
    private StudentRegisterCourse studentRegisterCourse;
    private StudentDropCourse studentDropCourse;
    private StudentViewMyCourse studentViewMyCourse;
    private StudentPageViewMyCourse studentPageViewMyCourse;
    private StudentViewSyllabus studentViewSyllabus;

    /**
     * Constructor
     */
    private UserInterface () {
        init();
    }

    /**
     * Init
     */
    private void init() { 
        lm = LoginManagement.getInstance();

        entryPage = new EntryPage();
        signInPage = new SignInPage();

        /** Admin Accounts */
        adminPage0 = new AdminPage0();
        adminPage1 = new AdminPage1();
        adminPage2 = new AdminPage2();
        adminPage3 = new AdminPage3();
        adminPageViewStudents = new AdminPageViewStudents();
        adminPageViewStudent = new AdminPageViewStudent();
        adminPageAddStudent = new AdminPageAddStudent();
        adminPageDeleteStudent = new AdminPageDeleteStudent();
        adminPageViewProfessors = new AdminPageViewProfessors();
        adminPageViewProfessor = new AdminPageViewProfessor();
        adminPageAddProfessor = new AdminPageAddProfessor();
        adminPageDeleteProfessor = new AdminPageDeleteProfessor(); 
        adminPageViewCourses = new AdminPageViewCourses();
        adminPageViewCourse = new AdminPageViewCourse();
        adminPageAddCourse = new AdminPageAddCourse();
        adminPageDeleteCourse = new AdminPageDeleteCourse();
        
        /** Professor Accounts */
        professorPage0 = new ProfessorPage0();
        professorViewMyCourses = new ProfessorViewMyCourses();
        professorViewMyCourse = new ProfessorViewMyCourse();
        professorPageViewMyCourse = new ProfessorPageViewMyCourse();
        professorViewStudents = new ProfessorViewStudents();
        professorAddSyllabus = new ProfessorAddSyllabus();
        professorGradeStudent = new ProfessorGradeStudent();

        /** Student Accounts */
        studentPage0 = new StudentPage0();
        studentRegisterForCourse = new StudentRegisterForCourse();
        studentViewAvailableCourses = new StudentViewAvailableCourses();
        studentViewMyCourses = new StudentViewMyCourses();
        studentRegisterCourse = new StudentRegisterCourse();
        studentDropCourse = new StudentDropCourse();
        studentViewMyCourse = new StudentViewMyCourse();
        studentPageViewMyCourse = new StudentPageViewMyCourse();
        studentViewSyllabus = new StudentViewSyllabus();
    }

    /**
     * Execute
     */
    public void execute() {
        welcome();
    }

    /**
     * Welcome
     */
    private void welcome() {
        entryPage.displayTitle();
        entryPage.displayOptions();

        switch(entryPage.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            signIn();
            break;

            default:
            wrongEntry();
            welcome();
        }
    }

    /**
     * Sign in
     */
    private void signIn() {
        signInPage.displayTitle();
        String userId = signInPage.getUserId();
        String password = signInPage.getPassword();

        if (userId.length() != 8) {
            System.out.println("\nUser ID not accepted.");
            welcome();
        }
        else {
            if (lm.isAuthorized(userId, password)) {
                System.out.println("\nUser is authorized");
                activeUser = lm.getActiveUser();
                System.out.println("User info: " + activeUser + "\n");
                if (activeUser.getRole().equalsIgnoreCase("Admin")) adminPage0();
                else if (activeUser.getRole().equalsIgnoreCase("Professor")) professorPage0();
                else if (activeUser.getRole().equalsIgnoreCase("Student")) studentPage0();
            }
            else {
                System.out.println("\nUser is not registered.\n");
                welcome();
            }
        }
    }

    /**
     * adminPage0
     */
    private void adminPage0() {
        adminPage0.displayTitle();
        adminPage0.displayOptions();

        switch(adminPage0.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            adminPage1();
            break;

            case 2:
            adminPage2();
            break;

            case 3:
            adminPage3();
            break;

            default:
            wrongEntry();
            adminPage0();
        }
    }

    /**
     * adminPage1
     */
    private void adminPage1() {
        adminPage1.displayTitle();
        adminPage1.displayOptions();

        switch(adminPage1.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            adminPage0();
            break;

            case 2:
            adminPageViewStudents();
            adminPage1();
            break;

            case 3:
            adminPageViewStudent();
            adminPage1();
            break;

            case 4:
            adminPageAddStudent();
            adminPage1();
            break;

            case 5:
            adminPageDeleteStudent();
            adminPage1();
            break;

            default:
            wrongEntry();
            adminPage1();
        }
    }

    /**
     * adminPage2
     */
    private void adminPage2() {
        adminPage2.displayTitle();
        adminPage2.displayOptions();

        switch(adminPage2.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            adminPage0();
            break;

            case 2:
            adminPageViewProfessors();
            adminPage2();
            break;

            case 3:
            adminPageViewProfessor();
            adminPage2();
            break;

            case 4:
            adminPageAddProfessor();
            adminPage2();
            break;

            case 5:
            adminPageDeleteProfessor();
            adminPage2();
            break;

            default:
            wrongEntry();
            adminPage2();
        }
    }

    /**
     * adminPage3
     */
    private void adminPage3() {
        adminPage3.displayTitle();
        adminPage3.displayOptions();

        switch(adminPage3.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            adminPage0();
            break;

            case 2:
            adminPageViewCourses();
            adminPage3();
            break;

            case 3:
            adminPageViewCourse();
            adminPage3();
            break;

            case 4:
            adminPageAddCourse();
            adminPage3();
            break;

            case 5:
            adminPageDeleteCourse();
            adminPage3();
            break;

            default:
            wrongEntry();
            adminPage3();
        }
    }

    /**
     * adminPageViewStudentProfiles
     */
    private void adminPageViewStudents() {
        adminPageViewStudents.viewStudents();
    }

    /**
     * adminPageViewStudent
     */
    private void adminPageViewStudent() {
        adminPageViewStudent.viewStudent();
    }

    /**
     * adminPageAddStudent
     */
    private void adminPageAddStudent() {
        adminPageAddStudent.addStudent();
    }

    /**
     * adminPageDeleteStudent
     */
    private void adminPageDeleteStudent() {
        adminPageDeleteStudent.deleteStudent();
    }

    /**
     * adminPageViewProfessors
     */
    private void adminPageViewProfessors() {
        adminPageViewProfessors.viewProfessors();
    }

     /**
     * adminPageViewProfessor
     */
    private void adminPageViewProfessor() {
        adminPageViewProfessor.viewProfessor();
    }

    /**
     * adminPageAddProfessor
     */
    private void adminPageAddProfessor() {
        adminPageAddProfessor.addProfessor();
    }

    /**
     * adminPageDeleteProfessor
     */
    private void adminPageDeleteProfessor() {
        adminPageDeleteProfessor.deleteProfessor();
    }

    /**
     * adminPageViewCourse
     */
    private void adminPageViewCourses() {
        adminPageViewCourses.viewCourses();
    }

    /**
     * adminPageViewCourses
     */
    private void adminPageViewCourse() {
        adminPageViewCourse.viewCourse();
    }

    /**
     * adminPageAddCourse
     */
    private void adminPageAddCourse() {
        adminPageAddCourse.addCourse();
    }

    /**
     * adminPageDeleteCourse
     */
    private void adminPageDeleteCourse() {
        adminPageDeleteCourse.deleteCourse();
    }

    /**
     * professorPage0
     */
    private void professorPage0() {
        professorPage0.displayTitle();
        professorPage0.displayOptions();

        switch(professorPage0.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            professorViewMyCourses();
            professorPage0();
            break;

            case 2:
            String courseId = professorViewMyCourse();
            if (courseId != null) { 
                professorPageViewMyCourse(courseId);
            }
            break;

            default:
            wrongEntry();
            professorPage0();
        }
    }

    /**
     * professorViewMyCourses
     */
    private void professorViewMyCourses() {
        professorViewMyCourses.viewMyCourses();
    }

    /**
     * professorViewMyCourses
     */
    private String  professorViewMyCourse() {
        return professorViewMyCourse.viewMyCourse();
    }

    /**
     * professorPageViewMyCourse()
     */
    private void professorPageViewMyCourse(String courseId) {
        professorPageViewMyCourse.displayTitle();
        professorPageViewMyCourse.displayOptions();

        switch(professorPageViewMyCourse.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            professorPage0();
            break;

            case 2:
            professorAddSyllabus(courseId);
            professorPageViewMyCourse(courseId);
            break;

            case 3:
            professorViewStudents(courseId);
            professorPageViewMyCourse(courseId);
            break;

            case 4:
            professorGradeStudent(courseId);
            professorPageViewMyCourse(courseId);
            break;

            default:
            wrongEntry();
            professorPageViewMyCourse(courseId);
        }
    }

    /**
     * professorAddSyllabus
     */
    private void professorAddSyllabus(String courseId) {
        professorAddSyllabus.addSyllabus(courseId);
    }

    /**
     * professorViewStudents
     */
    private void professorViewStudents(String courseId) {
        professorViewStudents.viewRegisteredStudents(courseId);
    }

    /**
     * professorGradeStudent
     */
    private void professorGradeStudent(String courseId) {
        professorGradeStudent.gradeStudent(courseId);
    }

    /**
     * studentPage0
     */
    private void studentPage0() {
        studentPage0.displayTitle();
        studentPage0.displayOptions();

        switch(studentPage0.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            studentViewMyCourses();
            studentPage0();
            break;

            case 2:
            String courseId = studentViewMyCourse();
            if (courseId != null) { studentPageViewMyCourse(courseId); }
            else { studentPage0(); }
            break;

            case 3:
            studentRegisterForCourse();
            studentPage0();
            break;

            case 4:
            studentDropCourse();
            studentPage0();
            break;

            default:
            wrongEntry();
            studentPage0();
        }
    }

    /**
     * studentViewMyCourses
     */
    private void studentViewMyCourses() {
        studentViewMyCourses.viewMyCourses();
    }

    /**
     * studentViewMyCourse
     */
    private String studentViewMyCourse() {
        return studentViewMyCourse.viewMyCourse();
    }

    /**
     * studentPageViewMyCourse
     */
    private void studentPageViewMyCourse(String courseId) {
        studentPageViewMyCourse.displayTitle();
        studentPageViewMyCourse.displayOptions();

        switch(studentPageViewMyCourse.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            studentPage0();
            break;

            case 2:
            studentViewSyllabus(courseId);
            studentPageViewMyCourse(courseId);
            break;

            default:
            wrongEntry();
            studentPageViewMyCourse(courseId);
        }
    }

    /**
     * studentRegisterForCourse
     */
    private void studentRegisterForCourse() {
        studentRegisterForCourse.displayTitle();
        studentRegisterForCourse.displayOptions();

        switch(studentRegisterForCourse.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            studentPage0();
            break;

            case 2:
            studentViewAvailableCourses();
            studentRegisterForCourse();
            break;

            case 3:
            studentRegisterCourse();
            studentRegisterForCourse();
            break;

            default:
            wrongEntry();
            studentRegisterForCourse();
        }
    }

    /**
     * studentViewSyllabus
     */
    private void studentViewSyllabus(String courseId) {
        studentViewSyllabus.viewSyllabus(courseId);
    }

    /**
     * studentViewAvailableCourses
     */
    private void studentViewAvailableCourses() {
        studentViewAvailableCourses.viewMyCourses();
    }

    /**
     * studentRegisterCourse
     */
    private void studentRegisterCourse() {
        studentRegisterCourse.registerCourse();
    }

    /**
     * studentDropCourse
     */
    private void studentDropCourse() {
        studentDropCourse.dropCourse();
    }

    private void wrongEntry() {
        System.out.println("Invalid entry. Try again !!! \n");
    }

    /**
     * Singleton instance
     */
    public static UserInterface getInstance() {
        if (ui == null) {
            ui = new UserInterface();
        }

        return ui;
    }
}
