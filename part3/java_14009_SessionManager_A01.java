// package declaration
package com.example.sessionmanager;

// import required classes
import java.util.HashMap;
import java.util.Map;

// SessionManager class java_14009_SessionManager_A01 class SessionManager {

    // Create a private map to store session IDs and users
    private Map<String, String> sessionMap;

    // Constructor
    public SessionManager() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a unique session ID
        String sessionID = generateSessionID();

        // Store the session ID and user ID in the map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionID)) {
            // Return the user ID associated with the session ID
            return sessionMap.get(sessionID);
        } else {
            // Return null if the session ID does not exist
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }

    // Method to generate a unique session ID
    private String generateSessionID() {
        // This is a simple implementation, you may want to use a UUID or some other unique identifier
        return String.valueOf(System.nanoTime());
    }
}