package com.uhv.cosc6342.isms.login;

import com.uhv.cosc6342.isms.users.User;
import com.uhv.cosc6342.isms.utils.Constants;

import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.time.Instant;

/**
* This is for logging all the users of the system
*/
public class Logger implements Constants {
    
    private static Logger logger = null;

    /**
     * Private constructor
     */

    /**
     * Update the logger with the user info
     */
    public void update(User user) {
        try {
            File file = new File(LOGGER_FILE);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            String userId = user.getUserId();
            String role = user.getRole();
            long time = Instant.now().toEpochMilli();

            bw.write(userId + "," + role + "," + time + "\n");
            bw.flush();
            bw.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Singleton instance
     */
    public static Logger getInstance() {
        if (logger == null) { logger = new Logger(); }
        return logger;
    }
}
