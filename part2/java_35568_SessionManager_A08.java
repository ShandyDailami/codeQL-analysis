import java.util.*;

public class java_35568_SessionManager_A08 {
    // A hashmap to store user sessions
    private Map<String, String> sessionMap;

    public java_35568_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session for a user
    public String createSession(String username) {
        // Generate a random UUID for session
        UUID uuid = UUID.randomUUID();
        String sessionId = uuid.toString();

        // Store the sessionId with the username in the session map
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the sessionId is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Get the username from the session map
            String username = sessionMap.get(sessionId);

            // Check if the username is valid (assume valid if username is not null)
            if (username != null) {
                return username;
            }
        }

        // If the sessionId is not valid, return null
        return null;
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Check if the sessionId is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // Remove the sessionId from the session map
            sessionMap.remove(sessionId);
        }
    }
}