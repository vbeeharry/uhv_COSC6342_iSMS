/**
 * LoginManagement.java
 */

package com.uhv.cosc6342.isms.loginSubsystem;

import com.uhv.cosc6342.isms.accountSubsystem.User;
import com.uhv.cosc6342.isms.utils.CsvReaderUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginManagement {

    private static LoginManagement lm = null;

    private PasswordMonitor pm;
    private Logger logger;

    private List userList;
    private boolean authorized = false;
    private User activeUser;

    /**
     * Private constructor
     */
    private LoginManagement () { 
        init();
    }

    /**
     * Init
     */
    private void init() {
        userList = CsvReaderUser.getInstance().getUserList();
        pm = PasswordMonitor.getInstance();
        logger = Logger.getInstance();
    }

    /**
     * Check if the user is authorized
     */
    public boolean isAuthorized(String userId, String password) {
        authorized = false;

        for (Iterator iter = userList.iterator(); iter.hasNext();) {
            User temp = (User) iter.next();
            if (temp.getUserId().equals(userId) && 
                //temp.getPassword().equals(password)) {
                pm.validate(temp.getPassword(), password)) {
                authorized = true;
                activeUser = temp;
                logger.update(activeUser);
            }
        }

        return authorized;
    }

    /**
     * Getter for active user
     */
    public User getActiveUser() {
        return activeUser;
    }

    /**
     * Singleton Instance
     */
    public static LoginManagement getInstance() {
        if (lm == null) {
            lm = new LoginManagement();
        }

        return lm;
    }
}
