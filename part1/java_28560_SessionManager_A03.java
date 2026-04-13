import java.util.HashMap;
import java.util.Map;

public class java_28560_SessionManager_A03 {
    // Store sessions in a HashMap for simplicity
    private Map<String, String> sessions;

    public java_28560_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Session creation
    public String createSession(String userId) {
        // Simple validation for the userId
        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }

        // Generate a random session id
        String sessionId = generateRandomSessionId();

        // Store session id in the map
        sessions.put(sessionId, userId);

        return sessionId;
    }

    // Session retrieval
    public String getUserIdFromSession(String sessionId) {
        // Validate session id
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Return user id from the map
        return sessions.get(sessionId);
    }

    // Session invalidation
    public void invalidateSession(String sessionId) {
        // Validate session id
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Remove session id from the map
        sessions.remove(sessionId);
    }

    // Simple method to generate a random session id
    private String generateRandomSessionId() {
        return String.valueOf(System.currentTimeMillis() * (Math.random() % 1000000));
    }
}