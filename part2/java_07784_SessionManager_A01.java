import java.util.HashMap;
import java.util.Map;

public class java_07784_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_07784_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null && !session.isExpired()) {
            return session;
        }
        return null;
    }

    public void destroySession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    private class Session {
        private String id;
        private long creationTime;

        public java_07784_SessionManager_A01(String id) {
            this.id = id;
            this.creationTime = System.currentTimeMillis();
        }

        public boolean isExpired() {
            long currentTime = System.currentTimeMillis();
            long creationTime = this.creationTime;
            long expirationTime = creationTime + 5000; // 5 seconds
            return currentTime > expirationTime;
        }
    }
}