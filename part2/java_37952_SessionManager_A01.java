import java.util.HashMap;
import java.util.Map;

public class java_37952_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    public java_37952_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public class Session {
        private String sessionId;

        public java_37952_SessionManager_A01(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}