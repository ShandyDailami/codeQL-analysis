import java.util.HashMap;

public class java_38763_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_38763_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session createSession() {
        Session session = new Session();
        sessions.put(session.getId(), session);
        return session;
    }

    public Session getSession(String id) {
        return sessions.get(id);
    }

    public void destroySession(String id) {
        sessions.remove(id);
    }

    private class Session {
        private String id;

        public java_38763_SessionManager_A01() {
            this.id = generateSessionId();
        }

        private String generateSessionId() {
            // This is a simple example of a session id generation. In a real application, you should use a secure random ID generator.
            return "session-" + System.currentTimeMillis();
        }

        public String getId() {
            return id;
        }
    }
}