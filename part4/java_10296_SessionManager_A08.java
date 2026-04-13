import java.util.HashMap;
import java.util.Map;

public class java_10296_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_10296_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        this.sessions.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return this.sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        this.sessions.remove(sessionId);
    }

    public void updateSessionData(String sessionId, String newSessionData) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        this.sessions.replace(sessionId, newSessionData);
    }

    public boolean isSessionValid(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return this.sessions.containsKey(sessionId);
    }

    public void clearAllSessions() {
        this.sessions.clear();
    }
}