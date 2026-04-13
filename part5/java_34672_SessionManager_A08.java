import java.util.HashMap;
import java.util.UUID;

public class java_34672_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_34672_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, new Session(sessionId));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if(session == null) {
            throw new SecurityException("Session not found: " + sessionId);
        }
        return session;
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_34672_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}