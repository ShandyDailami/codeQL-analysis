import java.util.HashMap;
import java.util.Map;

public class java_06067_SessionManager_A07 {

    // A map to store sessions
    private Map<String, String> sessionMap;

    public java_06067_SessionManager_A07() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userID) {
        // Generate a session ID and store it in the map
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    // Method to check the validity of a session
    public boolean checkSession(String sessionID) {
        // Check if the session ID exists in the map
        if (sessionMap.containsKey(sessionID)) {
            // If the session is valid, return true
            return true;
        } else {
            // If the session is not valid, return false
            return false;
        }
    }

    // Method to get the user ID from a session
    public String getUserID(String sessionID) {
        // Get the user ID from the session ID
        return sessionMap.get(sessionID);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }
}