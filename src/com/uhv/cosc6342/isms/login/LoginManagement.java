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
    private String role = null;

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
    public boolean isAuthorized(String userId, String password, String role) {
        for (Iterator iter = userList.iterator(); iter.hasNext();) {
            User temp = (User) iter.next();
            if (temp.getUserId().equals(userId) && temp.getPassword().equals(password)
                && temp.getRole().equals(role)) {
                    authorized = true;
                    this.role = role;
                    sharedObject.putObject("activeUser", temp);
                }
        }
        return false;
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
