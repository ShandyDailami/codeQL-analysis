import java.util.HashMap;
import java.util.Map;

public class java_13325_SessionManager_A01 {

    private Map<String, String> sessions;

    public java_13325_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (sessionData == null || sessionData.isEmpty()) {
            throw new IllegalArgumentException("Session data cannot be null or empty");
        }
        sessions.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        sessions.remove(sessionId);
    }

    public void updateSession(String sessionId, String newSessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (newSessionData == null || newSessionData.isEmpty()) {
            throw new IllegalArgumentException("New session data cannot be null or empty");
        }
        sessions.put(sessionId, newSessionData);
    }
}