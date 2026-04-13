import java.util.HashMap;
import java.util.Map;

public class java_37603_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_37603_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String user) {
        if (isSessionValid(sessionId)) {
            sessions.put(sessionId, user);
        } else {
            throw new IllegalArgumentException("Invalid session ID.");
        }
    }

    public String getUser(String sessionId) {
        if (isSessionValid(sessionId)) {
            return sessions.get(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID.");
        }
    }

    public void invalidateSession(String sessionId) {
        if (isSessionValid(sessionId)) {
            sessions.remove(sessionId);
        } else {
            throw new IllegalArgumentException("Invalid session ID.");
        }
    }

    private boolean isSessionValid(String sessionId) {
        return sessionId != null && !sessionId.isEmpty();
    }
}