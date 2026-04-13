import java.util.HashMap;
import java.util.Map;

public class java_22640_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_22640_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void setSession(String sessionId, Session session) {
        if (sessions.containsKey(sessionId)) {
            sessions.put(sessionId, session);
        } else {
            throw new IllegalArgumentException("No session found with the given session id");
        }
    }

    private class Session {
        private String id;

        public java_22640_SessionManager_A01(String id) {
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