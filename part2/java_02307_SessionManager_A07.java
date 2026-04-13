import java.util.HashMap;
import java.util.Map;

public class java_02307_SessionManager_A07 {
    // Session data is stored in a Map.
    private Map<String, String> sessionData;

    // SessionManager constructor.
    public java_02307_SessionManager_A07() {
        this.sessionData = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userId) {
        // Generate a session ID.
        String sessionId = userId + System.currentTimeMillis();

        // Store the session ID and user ID in the session data map.
        this.sessionData.put(sessionId, userId);

        return sessionId;
    }

    // Method to retrieve the user ID for a given session ID.
    public String getUserId(String sessionId) {
        // Retrieve the user ID from the session data map.
        return this.sessionData.get(sessionId);
    }

    // Method to destroy a session.
    public void destroySession(String sessionId) {
        // Remove the session ID from the session data map.
        this.sessionData.remove(sessionId);
    }
}