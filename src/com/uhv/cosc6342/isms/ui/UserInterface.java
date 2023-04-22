package com.uhv.cosc6342.isms.ui;

import com.uhv.cosc6342.isms.login.LoginManagement;
import com.uhv.cosc6342.isms.users.User;
import com.uhv.cosc6342.isms.utils.SharedObject;

/**
 * This is the UI Manager
 */
public class UserInterface {
    
    public static UserInterface ui = null;

    private UIInterface activeUI;
    private EntryPage entryPage;
    private SignInPage signInPage;

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
        entryPage = new EntryPage();
        signInPage = new SignInPage();
    
        welcome(entryPage);
    }

    /**
     * Welcome
     */
    private void welcome(UIInterface ui) {
        ui.displayTitle();
        ui.displayOptions();

        switch(ui.getSelection()) {
            case 0:
            System.exit(0);
            break;

            case 1:
            signIn(signInPage);
            break;

            default:
            wrongEntry();
            welcome(entryPage);
        }
    }

    /**
     * Sign in
     */
    private void signIn(UIInterface ui) {
        ui.displayTitle();
        String userId = ui.getUserId();
        String password = ui.getPassword();
        
        if (LoginManagement.getInstance().isAuthorized(userId, password)) {
            System.out.println("\nUser is authorized");
            User activeUser = (User) SharedObject.getInstance().getObject("activeUser");
            String role = activeUser.getRole();
            System.out.println("User info: " + activeUser);
        }
        else {
            System.out.println("\nUser is not registered.\n");
            welcome(entryPage);
        }
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
