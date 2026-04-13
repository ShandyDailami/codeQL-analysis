import java.util.HashMap;
import java.util.Map;

public class java_14774_SessionManager_A03 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_14774_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userID) {
        // Generate a session ID
        String sessionID = generateSessionID(userID);

        // Store the session ID and user ID in the map
        sessionMap.put(sessionID, userID);

        return sessionID;
    }

    // Method to get a session
    public String getSession(String sessionID) {
        // Return the user ID associated with the session ID
        return sessionMap.get(sessionID);
    }

    // Method to destroy a session
    public void destroySession(String sessionID) {
        // Remove the session ID from the map
        sessionMap.remove(sessionID);
    }

    // Helper method to generate a session ID
    private String generateSessionID(String userID) {
        // This is a simple hashing function, in a real application you should use a secure method
        return String.valueOf(userID.hashCode());
    }
}