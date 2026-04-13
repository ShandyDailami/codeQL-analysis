public class java_13114_SessionManager_A07 {

    // In-memory store for sessions
    private Map<String, Session> sessions = new HashMap<>();

    public String createSession(String username) {
        // Generate a random session ID
        String sessionId = UUID.randomUUID().toString();

        // Create a new session and store it in the map
        sessions.put(sessionId, new Session(username, sessionId));

        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Retrieve the session from the map
        Session session = sessions.get(sessionId);

        if (session == null) {
            return null;
        }

        return session.getUsername();
    }

    public void invalidateSession(String sessionId) {
        // Remove the session from the map
        sessions.remove(sessionId);
    }

    // Session class for holding username and session ID
    private class Session {
        private String username;
        private String sessionId;

        public java_13114_SessionManager_A07(String username, String sessionId) {
            this.username = username;
            this.sessionId = sessionId;
        }

        public String getUsername() {
            return username;
        }

        public String getSessionId() {
            return sessionId;
        }
    }
}