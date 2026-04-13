import java.util.HashMap;
import java.util.Map;

public class java_10448_SessionManager_A07 {

    // A map to simulate the in-memory session storage.
    private Map<String, String> sessionStorage;

    // Default Constructor.
    public java_10448_SessionManager_A07() {
        this.sessionStorage = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionStorage.put(sessionId, sessionId);
        return sessionId;
    }

    // Method to validate the session.
    public String validateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        if (sessionStorage.get(sessionId) == null) {
            throw new SecurityException("Invalid session ID: " + sessionId);
        }
        return sessionId;
    }

    // Method to destroy the session.
    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty.");
        }
        sessionStorage.remove(sessionId);
    }

    // Method to invalidate all sessions.
    public void invalidateAllSessions() {
        sessionStorage.clear();
    }
}