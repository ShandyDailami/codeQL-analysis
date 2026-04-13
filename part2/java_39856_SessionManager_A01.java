public class java_39856_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, Session> sessions;

    public java_39856_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (sessions.containsKey(sessionId)) {
            throw new IllegalArgumentException("A session with this ID already exists");
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new NoSuchElementException("No session found with this ID");
        }
        return session;
    }

    // Session class
    private class Session {
        private String id;

        public java_39856_SessionManager_A01(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Session ID cannot be null or empty");
            }
            this.id = id;
        }
    }
}