import java.util.HashMap;
import java.util.Map;

public class java_07149_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_07149_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_07149_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}