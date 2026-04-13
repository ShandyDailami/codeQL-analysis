import java.util.HashMap;

public class java_36338_SessionManager_A07 {

    private HashMap<String, String> sessions;

    public java_36338_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate the session
    public String validateSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new AuthFailureException("Session not found or has expired.");
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new AuthFailureException("Session not found or has expired.");
        }
    }
}