import java.util.HashMap;
import java.util.Map;

public class java_39429_SessionManager_A07 {
    // A HashMap to store user sessions.
    private Map<String, String> sessionMap;

    // Constructor.
    public java_39429_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userID) {
        // Generate a session ID.
        String sessionID = String.valueOf(System.currentTimeMillis());

        // Store the session ID and user ID in the session map.
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to get the user ID for a given session ID.
    public String getUserID(String sessionID) {
        // Return the user ID if the session ID exists in the map.
        return sessionMap.get(sessionID);
    }

    // Method to remove a session.
    public void removeSession(String sessionID) {
        // Remove the session ID from the map.
        sessionMap.remove(sessionID);
    }
}