/**
 * LoginManagement.java
 */

package com.uhv.cosc6342.isms.login;

public class LoginManagement {

    private static LoginManagement lm = null;

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
