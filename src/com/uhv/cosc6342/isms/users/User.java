/**
 *
 * User.java
 */

package com.uhv.cosc6342.isms.users;

import com.uhv.cosc6342.isms.utils.Debug;

/**
 * Abstract users class
 */
public abstract class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    protected Debug debug;
    
    /**
     * Constructor
     */
    public User (String firstName, String lastName, 
                String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        debug = Debug.getInstance();
    }

    public User (String[] temp) {
        this(temp[0], temp[1], temp[2], temp[3], temp[4]);
    }

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
     * Getter for role
     */
    public String getRole() {
        return role;
    }
}
