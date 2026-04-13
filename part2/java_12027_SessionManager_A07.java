import java.util.HashMap;
import java.util.Map;

public class java_12027_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private Map<String, String> userMap;

    public java_12027_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    // Method to authenticate a user
    public void authenticateUser(String username, String password) {
        if (username != null && password != null) {
            userMap.put(username, password);
        } else {
            throw new IllegalArgumentException("Username and password must not be null.");
        }
    }

    // Method to start a session for a user
    public String startSession(String username) {
        String sessionId = null;

        // Check if user is authenticated
        if (userMap.containsKey(username)) {
            // Generate a session ID
            sessionId = generateSessionId();

            // Store session ID in the session map
            sessionMap.put(sessionId, username);
        }

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        if (sessionId != null && sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);

            // Remove the user from the user map
            userMap.remove(username);
        }
    }

    // Method to get the user name for a given session ID
    public String getUserNameForSession(String sessionId) {
        String username = null;

        if (sessionId != null && sessionMap.containsKey(sessionId)) {
            username = sessionMap.get(sessionId);
        }

        return username;
    }

    // Method to generate a session ID
    private String generateSessionId() {
        // This is a simple example, in a real application you'd want to use a UUID or similar
        return String.valueOf(System.currentTimeMillis());
    }
}