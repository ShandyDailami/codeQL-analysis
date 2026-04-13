public class java_13038_SessionManager_A08 {
    // Field for storing sessions
    private Map<String, Session> sessions;

    public java_13038_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with id: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with id: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    // Session class
    class Session {
        private String id;

        public java_13038_SessionManager_A08(String id) {
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