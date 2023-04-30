package com.uhv.cosc6342.isms.ui;

import com.uhv.cosc6342.isms.login.LoginManagement;
import com.uhv.cosc6342.isms.ui.admin.*;
import com.uhv.cosc6342.isms.users.User;

/**
 * This is the UI Manager
 */
public class UserInterface {
    
    public static UserInterface ui = null;

    private LoginManagement lm;

    private User activeUser = null;

    private EntryPage entryPage;
    private SignInPage signInPage;
    private AdminPage0 adminPage0;
    private AdminPage1 adminPage1;
    private AdminPageViewStudents adminPageViewStudents;
    private AdminPageViewStudent adminPageViewStudent;
    private AdminPageAddStudent adminPageAddStudent;
    private AdminPageDeleteStudent adminPageDeleteStudent;

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
        adminPage0 = new AdminPage0();
        adminPage1 = new AdminPage1();
        adminPageViewStudents = new AdminPageViewStudents();
        adminPageViewStudent = new AdminPageViewStudent();
        adminPageAddStudent = new AdminPageAddStudent();
        adminPageDeleteStudent = new AdminPageDeleteStudent();
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
        
        if (lm.isAuthorized(userId, password)) {
            System.out.println("\nUser is authorized");
            activeUser = lm.getActiveUser();
            System.out.println("User info: " + activeUser + "\n");
            adminPage0();
        }
        else {
            System.out.println("\nUser is not registered.\n");
            welcome();
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

            case 3:
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

        switch(adminPage0.getSelection()) {
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
