package com.dgtic.unam.configuration;

import java.util.logging.Logger;

public class AuditServiceSingleton {
    private static AuditServiceSingleton instance;
    private final Logger logger = Logger.getLogger(AuditServiceSingleton.class.getName());

    private AuditServiceSingleton() {
    }

    public static AuditServiceSingleton getInstance() {
        if (instance == null) {
            instance = new AuditServiceSingleton();
        }
        return instance;
    }

    public void log(String userId, String action, String details) {
        logger.info("USER ID: " + userId + " ACTION: " + action + " DETAILS: " + details);
    }


}
