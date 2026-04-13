import java.util.HashMap;

public class java_32135_SessionManager_A07 {
    private HashMap<String, String> sessions;

    public java_32135_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId(); // this should be a secure operation that generates a unique id
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        if (validateSessionId(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session id");
        }
    }

    private String generateSessionId() {
        // this should be a secure operation that generates a unique id
        return "SESSION_" + System.currentTimeMillis();
    }

    private boolean validateSessionId(String sessionId) {
        // this should be a secure operation that validates the session id
        return sessions.containsKey(sessionId);
    }
}