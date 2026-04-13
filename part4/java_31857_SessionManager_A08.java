import java.util.HashMap;
import java.util.Map;

public class java_31857_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_31857_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Simulate a security check for integrity failure
        if (sessionId.equals("FAILURE")) {
            throw new SecurityException("Session integrity failure");
        }

        Session session = sessions.get(sessionId);
        if (session == null) {
            session = new Session(sessionId);
            sessions.put(sessionId, session);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Simulate a security check for integrity failure
        if (sessionId.equals("FAILURE")) {
            throw new SecurityException("Session integrity failure");
        }

        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_31857_SessionManager_A08(String id) {
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