public class java_07514_SessionManager_A08 {

    // A simple in-memory store of sessions
    private Map<String, Session> sessions;

    public java_07514_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID can't be null or empty");
        }

        // Create a new session and store it in the map
        sessions.put(sessionId, new Session(sessionId));
        return sessions.get(sessionId);
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Session class is simple for the purpose of this example
    private class Session {
        private String id;

        public java_07514_SessionManager_A08(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        // Simulate integrity failure when accessing an inaccessible session
        public void setInvalid(boolean invalid) {
            if (invalid) {
                throw new SecurityException("Attempted to access an invalid session");
            }
        }

        public boolean isValid() {
            return !isInvalid();
        }

        // Simulate integrity failure when attempting to access an inaccessible session
        public boolean isInvalid() {
            return true;
        }
    }
}