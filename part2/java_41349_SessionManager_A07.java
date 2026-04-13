import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_41349_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_41349_SessionManager_A07() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        Session session = getSession(sessionId);
        if (session.isExpired()) {
            throw new IllegalStateException("Session expired: " + sessionId);
        }
    }

    public class Session {
        private String sessionId;
        private long creationTime;

        public java_41349_SessionManager_A07(String sessionId) {
            this.sessionId = sessionId;
            this.creationTime = System.currentTimeMillis();
        }

        public String getSessionId() {
            return sessionId;
        }

        public boolean isExpired() {
            long expirationTime = this.creationTime + 10 * 60 * 1000; // 10 minutes
            return System.currentTimeMillis() > expirationTime;
        }
    }
}