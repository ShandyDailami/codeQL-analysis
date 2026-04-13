import java.util.HashMap;

public class java_14461_SessionManager_A03 {
    private HashMap<String, String> sessions;

    public java_14461_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Create a session
    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Validate if a session is valid
    public boolean validateSession(String sessionId) {
        // In a real application, you would likely want to compare the session ID with a hash of the user ID and a timestamp to ensure the session is still valid.
        // However, for this example, we'll just assume it's valid if it exists.
        return sessions.containsKey(sessionId);
    }

    // Get the user ID associated with a session
    public String getUserId(String sessionId) {
        if (!validateSession(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return sessions.get(sessionId);
    }

    // Generate a session ID
    private String generateSessionId() {
        // In a real application, you would likely want to use a UUID or a similar mechanism to ensure uniqueness.
        // For this example, we'll just use a simple counter.
        static int sessionIdCounter = 0;
        sessionIdCounter++;
        return "SESSION_" + sessionIdCounter;
    }
}