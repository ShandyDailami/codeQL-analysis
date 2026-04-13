import java.util.HashMap;

public class java_04161_SessionManager_A08 {
    // A map to store session IDs and their corresponding user IDs
    private HashMap<String, String> sessionMap;

    // Constructor to initialize the session map
    public java_04161_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a random session ID
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Add the session ID and user ID to the session map
        sessionMap.put(sessionID, userID);

        // Return the session ID
        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID, String expectedUserID) {
        // If the session map does not contain the session ID or the user ID
        // in the session map does not match the expected user ID, return false
        if (!sessionMap.containsKey(sessionID) || !sessionMap.get(sessionID).equals(expectedUserID)) {
            return false;
        }

        // If the session map contains the session ID and the user ID, return true
        return true;
    }

    // Method to end a session
    public void endSession(String sessionID) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionID);
    }
}