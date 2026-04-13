import java.util.HashMap;
import java.util.Map;

public class java_27220_SessionManager_A08 {
    // Data structure to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_27220_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a random session ID
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, username);
        return sessionID;
    }

    // Method to validate a session
    public String validateSession(String sessionID) {
        // Check if the session ID is in the map
        if (sessionMap.containsKey(sessionID)) {
            // Return the username associated with the session ID
            return sessionMap.get(sessionID);
        } else {
            // Return null if the session ID is not in the map
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}