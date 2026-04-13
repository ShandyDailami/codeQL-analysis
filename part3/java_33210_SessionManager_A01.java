import java.util.HashMap;
import java.util.Map;

public class java_33210_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    // Private constructor to prevent instantiation
    private java_33210_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Singleton instance
    private static class SingletonHolder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session found with id: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Session class
    private class Session {
        private String sessionId;

        public java_33210_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}