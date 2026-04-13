import java.util.*;

public class java_33793_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_33793_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        sessions.remove(sessionId);
    }
}

class Session {
    private String sessionId;

    public java_33793_SessionManager_A08(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        this.sessionId = sessionId;
    }

    public void invalidate() {
        // Implementation of the security-sensitive operation related to A08_IntegrityFailure
        // You may use standard Java libraries or implement it yourself
    }
}