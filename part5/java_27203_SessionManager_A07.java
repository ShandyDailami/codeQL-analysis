public class java_27203_SessionManager_A07 {

    // Instance variables to hold our sessions
    private HashMap<String, Session> sessions;

    public java_27203_SessionManager_A07() {
        // Create a new HashMap to hold our sessions
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        // Create a new Session object
        Session session = new Session();
        // Set the session id
        session.setSessionId(sessionId);
        // Add the session to our sessions map
        sessions.put(sessionId, session);
        // Return the session
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        // Return the session from our sessions map
        return sessions.get(sessionId);
    }

    // Session class
    public class Session {

        private String sessionId;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}