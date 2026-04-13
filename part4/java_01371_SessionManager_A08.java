import java.util.HashMap;
import java.util.Map;

public class java_01371_SessionManager_A08 {
    // A map to simulate a session storage
    private Map<String, String> sessionStorage;

    // Constructor
    public java_01371_SessionManager_A08() {
        sessionStorage = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = userID + System.currentTimeMillis();

        // Store the session ID in the session storage
        sessionStorage.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Method to get the userID from a session
    public String getUserID(String sessionID) {
        // Return the userID from the session storage
        return sessionStorage.get(sessionID);
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Remove the session ID from the session storage
        sessionStorage.remove(sessionID);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionID) {
        // Check if the session ID exists in the session storage
        return sessionStorage.containsKey(sessionID);
    }

    // Method to check if a userID exists
    public boolean hasUserID(String userID) {
        // Iterate over all session IDs
        for (String sessionID : sessionStorage.keySet()) {
            // If the session ID belongs to the given userID, return true
            if (sessionStorage.get(sessionID).equals(userID)) {
                return true;
            }
        }

        // If no session ID belongs to the given userID, return false
        return false;
    }

    // Method to clear all sessions
    public void clearSessions() {
        // Remove all session IDs from the session storage
        sessionStorage.clear();
    }

    // Method to clear all userIDs
    public void clearUserIDs() {
        // Iterate over all session IDs
        for (String sessionID : sessionStorage.keySet()) {
            // Iterate over all userIDs
            for (String userID : sessionStorage.values()) {
                // If the session ID belongs to the given userID, remove it
                if (userID.equals(sessionStorage.get(sessionID))) {
                    sessionStorage.remove(sessionID);
                    break;
                }
            }
        }
    }
}