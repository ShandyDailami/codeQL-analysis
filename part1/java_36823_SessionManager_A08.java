import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_36823_SessionManager_A08 {

    // Create a ConcurrentHashMap to store sessions
    private final Map<String, Session> sessions;

    public java_36823_SessionManager_A08() {
        this.sessions = new ConcurrentHashMap<>();
    }

    // Start a new session
    public String startSession() {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    // End a session
    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Check if a session is active
    public boolean isSessionActive(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Generate a session ID
    private String generateSessionId() {
        return String.valueOf(System.nanoTime());
    }

    // Inner class to represent a session
    private class Session {
        private final String sessionId;

        public java_36823_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        // Add methods for session related operations here
    }
}