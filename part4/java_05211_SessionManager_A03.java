import java.util.HashMap;
import java.util.Map;

public class java_05211_SessionManager_A03 {
    // Use a HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_05211_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Store the session ID and username in the session map
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    // Method to get the username from a session
    public String getUsernameFromSession(String sessionID) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionID)) {
            // Return the username from the session map
            return sessionMap.get(sessionID);
        } else {
            // Return null if the session ID is not in the session map
            return null;
        }
    }

    // Method to validate a session
    public boolean validateSession(String sessionID) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionID)) {
            // Return true if the session ID is in the session map
            return true;
        } else {
            // Return false if the session ID is not in the session map
            return false;
        }
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionID) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionID)) {
            // Remove the session ID and username from the session map
            sessionMap.remove(sessionID);
        }
    }
}