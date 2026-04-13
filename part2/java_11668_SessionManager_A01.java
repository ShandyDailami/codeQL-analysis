import java.util.HashMap;
import java.util.Map;

public class java_11668_SessionManager_A01 {

    // This is a simple in-memory store for user sessions.
    private Map<String, String> sessionMap = new HashMap<>();

    // Add a new session.
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if a session exists.
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Check if a user is authorized to access a session.
    public boolean isUserAuthorized(String sessionId, String userId) {
        if (!hasSession(sessionId)) {
            throw new IllegalArgumentException("Invalid session id.");
        }

        String expectedUserId = sessionMap.get(sessionId);
        return expectedUserId.equals(userId);
    }

}