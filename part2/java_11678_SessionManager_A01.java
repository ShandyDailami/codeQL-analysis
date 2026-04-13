import java.util.HashMap;
import java.util.Map;

public class java_11678_SessionManager_A01 {
    // A map to store user sessions.
    private Map<String, String> sessionMap;

    // Initialize the session map.
    public java_11678_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Add a new session.
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Remove a session.
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Get the user ID associated with the given session ID.
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Check if the given session ID exists in the map.
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Check if the user with the given user ID has a session.
    public boolean isUserActive(String userId) {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                return true;
            }
        }
        return false;
    }

    // This method should only be called by the user who owns the session.
    // It checks if the session is valid and the user is active.
    // If both are true, it returns true. If not, it throws an exception.
    public boolean validateSession(String sessionId, String userId) {
        if (isValidSession(sessionId) && isUserActive(userId)) {
            return true;
        } else {
            throw new IllegalStateException("Invalid session or user is not active");
        }
    }
}