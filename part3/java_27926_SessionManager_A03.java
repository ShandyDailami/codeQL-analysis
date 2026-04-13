import java.util.HashMap;
import java.util.Map;

public class java_27926_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_27926_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(Object sessionObject) {
        String sessionId = UUID.randomUUID().toString();
        Session session = new Session(sessionId, sessionObject);
        sessions.put(sessionId, session);
        return sessionId;
    }

    public Object getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return session.getSessionObject();
    }

    public void destroySession(String sessionId) {
        Session session = sessions.remove(sessionId);
        if (session == null) {
            throw new IllegalArgumentException("Invalid session ID");
        }
    }

    private class Session {
        private String sessionId;
        private Object sessionObject;

        public java_27926_SessionManager_A03(String sessionId, Object sessionObject) {
            this.sessionId = sessionId;
            this.sessionObject = sessionObject;
        }

        public String getSessionId() {
            return sessionId;
        }

        public Object getSessionObject() {
            return sessionObject;
        }
    }
}