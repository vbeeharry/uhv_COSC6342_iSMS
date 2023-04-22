package com.uhv.cosc6342.isms.utils;

import java.util.Map;
import java.util.HashMap;

/**
 * A class to hold objects
 */
public class SharedObject {
    
    public static SharedObject sharedObject = null;

    private Map hmObject;

    /**
     * Constructor
     */
    private SharedObject () { 
        init();
    }

    /**
     * Init
     */
    private void init() {
        hmObject = new HashMap();
    }

    /**
     * Put Object
     */
    public void putObject(String key, Object value) {
        hmObject.put(key, value);
    }

    /**
     * Get the Object
     */
    public Object getObject(String key) {
        return hmObject.get(key);
    }

    /**
     * Singleton instance
     */
    public static SharedObject getInstance() {
        if (sharedObject == null) {
            sharedObject = new SharedObject();
        }

        return sharedObject;
    }
}
