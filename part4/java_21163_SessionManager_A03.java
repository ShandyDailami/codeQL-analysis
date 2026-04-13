import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class java_21163_SessionManager_A03 {
    private Map<String, Session> sessions;

    public java_21163_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session with id " + sessionId + " not found");
        }
        return session;
    }

    public void validateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new SessionNotFoundException("Session with id " + sessionId + " not found");
        }
    }

    public Collection<Session> getAllSessions() {
        return sessions.values();
    }

    private static class Session {
        private String id;

        public java_21163_SessionManager_A03(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    private static class SessionNotFoundException extends RuntimeException {
        public java_21163_SessionManager_A03(String message) {
            super(message);
        }
    }
}