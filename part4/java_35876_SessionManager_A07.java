import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class java_35876_SessionManager_A07 {
    private ConcurrentHashMap<String, Session> sessions;

    public java_35876_SessionManager_A07() {
        sessions = new ConcurrentHashMap<>();
    }

    public String createSession(Object user) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(user, sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private Object user;
        private String sessionId;

        public java_35876_SessionManager_A07(Object user, String sessionId) {
            this.user = user;
            this.sessionId = sessionId;
        }

        public Object getUser() {
            return user;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}