import java.util.HashMap;
import java.util.Map;

public class java_40026_SessionManager_A01 {
    private Map<String, Session> sessionMap;

    public java_40026_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session with id " + sessionId + " already exists.");
        }
        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found for id " + sessionId);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        Session session = sessionMap.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found for id " + sessionId);
        }
        sessionMap.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_40026_SessionManager_A01(String id) {
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