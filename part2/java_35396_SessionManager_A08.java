import java.util.HashMap;
import java.util.Map;

// SessionManager class java_35396_SessionManager_A08 implements a session management system.
public class SessionManager {

    private Map<String, String> sessions;

    public SessionManager() {
        sessions = new HashMap<>();
    }

    // Method to create a session.
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId of a session.
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to check if a session is valid.
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to invalidate a session.
    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}