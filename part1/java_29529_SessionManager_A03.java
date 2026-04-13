import java.util.HashMap;
import java.util.Map;

public class java_29529_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_29529_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("A session with the ID " + sessionId + " already exists");
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
       
        }

        Session session = sessions.get(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session with the ID " + sessionId + " exists");
        }

        return session;
    }

    public void destroySession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        Session session = sessions.remove(sessionId);

        if (session == null) {
            throw new IllegalStateException("No session with the ID " + sessionId + " exists");
        }
    }

    public static class Session {
        private String id;

        public java_29529_SessionManager_A03(String id) {
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