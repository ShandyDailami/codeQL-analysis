import java.util.HashMap;
import java.util.Map;

public class java_41835_SessionManager_A07 {
    // Using a HashMap to store user sessions.
    private Map<String, String> sessionMap;

    // Constructor
    public java_41835_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session for a user.
    public String createSession(String userName) {
        // Generate a session ID using user name.
        String sessionId = userName + System.currentTimeMillis();

        // Store session ID and user name in the session map.
        sessionMap.put(sessionId, userName);

        return sessionId;
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId) {
        // Check if the session ID is in the session map.
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the user name associated with a session.
    public String getUserName(String sessionId) {
        // Check if the session ID is in the session map.
        if (validateSession(sessionId)) {
            // If the session ID is valid, return the associated user name.
            return sessionMap.get(sessionId);
        } else {
            // If the session ID is not valid, return null.
            return null;
        }
    }
}