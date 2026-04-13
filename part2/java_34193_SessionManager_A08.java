import java.util.HashMap;
import java.util.Map;

public class java_34193_SessionManager_A08 {
    private Map<String, Session> sessionMap;

    public java_34193_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session not found with id: " + sessionId);
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session not found with id: " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String sessionId;

        public java_34193_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}