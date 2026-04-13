import java.util.HashMap;
import java.util.Map;

public class java_14716_SessionManager_A01 {
    // Store sessions in a Map
    private Map<String, String> sessions;

    public java_14716_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    // Method to get a username from a session
    public String getUsernameFromSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}