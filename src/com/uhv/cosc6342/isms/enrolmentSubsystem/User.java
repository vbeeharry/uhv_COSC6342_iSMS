
/**
 *
 * User.java
 */

package com.uhv.cosc6342.isms.enrolmentSubsystem;

import com.uhv.cosc6342.isms.utils.Debug;

/**
 * Abstract users class
 */
public abstract class User {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String userId;
    private String password;
    private String role;

    protected Debug debug;
    
    /**
     * Constructor
     */
    public User (String firstName, String lastName, 
                String email, String userId, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.password = password;
        this.role = role;
        debug = Debug.getInstance();
        init();
    }

    public User (String[] temp) {
        this(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
    }

    /**
     * Init
     */
    private void init() { 
        initMe();
    }

    /**
     * InitMe()
     */
    protected abstract void initMe();

    /**
     * Getter for firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter for lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter for email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Getter for password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter for the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Getter for role
     */
    public String getRole() {
        return role;
    }

    /**
     * ToString
     */
    public String toString() {
        return (firstName + " " + lastName + "." + " Role : " + role);
    }
}
