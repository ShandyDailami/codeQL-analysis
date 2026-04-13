public class java_29679_SessionManager_A03 {
    // A simple hashmap to store the sessions
    private Map<String, Session> sessions;

    public java_29679_SessionManager_A03() {
        // Initialize the sessions map
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        // Create a new session and add it to the map
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        // Get the session from the map
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        // Remove the session from the map
        sessions.remove(sessionId);
    }

    private class Session {
        private String id;

        public java_29679_SessionManager_A03(String id) {
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