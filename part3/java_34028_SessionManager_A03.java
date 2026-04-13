import java.util.HashMap;
import java.util.Map;

public class java_34028_SessionManager_A03 {
    private Map<String, Session> sessionMap;

    public java_34028_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }
        sessionMap.put(sessionId, new Session(sessionId));
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session exists with id: " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_34028_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}