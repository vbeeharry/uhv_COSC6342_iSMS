/**
 * LoginManagement.java
 */

package com.uhv.cosc6342.isms.login;

import com.uhv.cosc6342.isms.users.User;
import com.uhv.cosc6342.isms.utils.SharedObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginManagement {

    private static LoginManagement lm = null;

    private SharedObject sharedObject = SharedObject.getInstance();

    private List userList;
    private boolean authorized = false;

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
        userList = (ArrayList) sharedObject.getObject("userList");
    }

    /**
     * Check if the user is authorized
     */
    public boolean isAuthorized(String userId, String password) {
        for (Iterator iter = userList.iterator(); iter.hasNext();) {
            User temp = (User) iter.next();
            if (temp.getUserId().equals(userId) && temp.getPassword().equals(password)) {
                authorized = true;
                sharedObject.putObject("activeUser", temp);
            }
        }
        return authorized;
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
