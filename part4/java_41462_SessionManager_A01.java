import java.util.HashMap;
import java.util.Map;

public class java_41462_SessionManager_A01 {
    private Map<String, Session> sessions;

    public java_41462_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session with id " + sessionId + " already exists.");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session with id " + sessionId + " exists.");
        }

        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("No session with id " + sessionId + " exists.");
        }

        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_41462_SessionManager_A01(String id) {
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