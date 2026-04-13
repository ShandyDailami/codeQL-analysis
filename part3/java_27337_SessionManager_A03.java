import java.util.HashMap;

public class java_27337_SessionManager_A03 {
    private HashMap<String, Session> sessions;

    public java_27337_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, new Session(username));
        return sessionId;
    }

    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        Session session = sessions.get(sessionId);
        validateSession(session);
        return session;
    }

    private void validateSession(Session session) {
        // Here you can implement your security-sensitive operations, like checking if a session is still valid
        // For example, you can check if the session is still active
        // For now, we'll just throw an exception
        if (!session.isActive()) {
            throw new IllegalStateException("Invalid session");
        }
    }

    private String generateSessionId() {
        // Here you can implement your own session ID generation, for example using UUID
        return UUID.randomUUID().toString();
    }

    private class Session {
        private String username;
        private boolean active;

        public java_27337_SessionManager_A03(String username) {
            this.username = username;
            this.active = true;
        }

        public boolean isActive() {
            return active;
        }
    }
}