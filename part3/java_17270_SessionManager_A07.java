import java.util.HashMap;
import java.util.Map;

public class java_17270_SessionManager_A07 {
    // Map to store session data
    private Map<String, String> sessionMap;

    // Constructor
    public java_17270_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = userID + "_" + System.currentTimeMillis();
        // Store the session ID in the map
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to validate a session
    public String getUserID(String sessionID) {
        // Return the user ID from the map
        return sessionMap.get(sessionID);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}