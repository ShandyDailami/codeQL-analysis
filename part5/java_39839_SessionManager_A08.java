import java.util.HashMap;

public class java_39839_SessionManager_A08 {
    private HashMap<String, Object> sessions;

    public java_39839_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, Object sessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.put(sessionId, sessionData);
    }

    public Object getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessions.get(sessionId);
    }

    public void updateSession(String sessionId, Object sessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.remove(sessionId);
    }
}