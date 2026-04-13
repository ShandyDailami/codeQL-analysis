import java.util.HashMap;
import java.util.Map;

public class java_26383_SessionManager_A07 {
    // We use a HashMap to simulate a database, storing sessions by user ID
    private Map<String, String> sessionMap;

    public java_26383_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session for a user
    public String createSession(String userId) {
        // Generate a session ID (this is a placeholder)
        String sessionId = "session-" + userId;
        sessionMap.put(userId, sessionId);
        return sessionId;
    }

    // Method to get the session for a user
    public String getSession(String userId) {
        // Get the session ID from the database (this is a placeholder)
        return sessionMap.get(userId);
    }

    // Method to remove a session for a user
    public void removeSession(String userId) {
        sessionMap.remove(userId);
    }
}