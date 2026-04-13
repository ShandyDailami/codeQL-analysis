import java.util.HashMap;

public class java_33470_SessionManager_A07 {
    // Use a HashMap to store sessions
    private HashMap<String, String> sessionMap = new HashMap<>();

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = userID + "_" + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Validate the session ID
        if (sessionMap.containsKey(sessionID)) {
            // Return true if session is valid
            return true;
        } else {
            // Return false if session is not valid
            return false;
        }
    }

    // Method to get the user ID from a session
    public String getUserIDFromSession(String sessionID) {
        // Return the user ID from the session
        return sessionMap.get(sessionID);
    }
}