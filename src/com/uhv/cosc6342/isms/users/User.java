/**
 *
 * User.java
 */

package com.uhv.cosc6342.isms.users;

/**
 * Abstract users class
 */
public abstract class User {

    protected String name;
    protected String email;
    protected String password;
    protected String role;
    
    /**
     * Constructor
     */
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
