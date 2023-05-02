/*
* PasswordGenerator.java
*/
 
package com.uhv.cosc6342.isms.loginSubsystem;

import java.security.MessageDigest;

/**
 * Generate the password
 */
public class PasswordGenerator {
    
    public static PasswordGenerator pg = null;

    /**
     * Constructor
     */
    private PasswordGenerator() { }

    /**
     *  Create the password in hash format
     */
    public String createPassword(String input) {
        String hash = "";

        try {      
            hash = computeHash(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hash;
    }

    /**
     * Computes the SHA-1 hash of the input string
     */
    private String computeHash(String x) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(x.getBytes());

        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }

        return sb.toString();
     }

    /**
     * Singleton Instance
     */
    public static PasswordGenerator getInstance() {
        if (pg == null) { pg = new PasswordGenerator(); }
        return pg;
    }
}
