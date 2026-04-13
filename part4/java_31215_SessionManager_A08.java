import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class java_31215_SessionManager_A08 {
    private ConcurrentHashMap<UUID, String> sessions;

    public java_31215_SessionManager_A08() {
        sessions = new ConcurrentHashMap<>();
    }

    public String createSession(String userId) {
        // Generate a unique ID for the session
        UUID sessionId = UUID.randomUUID();

        // Store the session with its ID and user ID
        sessions.put(sessionId, userId);

        return sessionId.toString();
    }

    public String getUserId(String sessionId) {
        // Validate the session ID
        if (!isValidSessionId(sessionId)) {
            throw new SecurityException("Invalid session ID");
        }

        // Retrieve the user ID from the session
        return sessions.get(UUID.fromString(sessionId));
    }

    public boolean isValidSessionId(String sessionId) {
        // Validate the session ID by checking if it's in our session map
        return sessions.containsKey(UUID.fromString(sessionId));
    }
}