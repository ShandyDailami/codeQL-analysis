import java.util.HashMap;
import java.util.Map;

public class java_07334_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_07334_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session openSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IntegrityFailure("Attempted to open session with ID: " + sessionId + ". This session already exists.");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public void closeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IntegrityFailure("Attempted to close session with ID: " + sessionId + ". No such session exists.");
        }
        sessions.remove(sessionId);
    }

    public static class Session {
        private String id;

        public java_07334_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class IntegrityFailure extends RuntimeException {
        public java_07334_SessionManager_A08(String message) {
            super(message);
        }
    }
}