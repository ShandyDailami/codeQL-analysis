import java.util.HashMap;
import java.util.Map;

public class java_12480_SessionManager_A07 {
    private Map<String, Session> sessionMap;

    public java_12480_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with given ID already exists!");
        }

        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with given ID exists!");
        }

        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with given ID exists!");
        }

        sessionMap.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_12480_SessionManager_A07(String id) {
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