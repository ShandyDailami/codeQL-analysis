import java.util.HashMap;
import java.util.Map;

public class java_32059_SessionManager_A07 {
    // A map to store user sessions.
    private Map<String, String> sessionMap;

    public java_32059_SessionManager_A07() {
        // Initialize the session map.
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String userId) {
        // Generate a session id for the user.
        String sessionId = userId + System.currentTimeMillis();

        // Store the session id in the session map.
        sessionMap.put(sessionId, userId);

        // Return the session id.
        return sessionId;
    }

    // Method to validate a session.
    public String validateSession(String sessionId) {
        // Check if the session map contains the session id.
        if (sessionMap.containsKey(sessionId)) {
            // Return the user id from the session map.
            return sessionMap.get(sessionId);
        }

        // Return null if the session is not valid.
        return null;
    }
}