import java.util.HashMap;
import java.util.Map;

public class java_08737_SessionManager_A08 {
    private Map<String, Session> sessions;

    public java_08737_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        String sessionId = generateSessionId();
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple way to generate a session id. In a real-world scenario,
        // you would likely use a UUID or some other form of unique identifier.
        return String.valueOf(System.currentTimeMillis());
    }

    private class Session {
        private String id;

        public java_08737_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}