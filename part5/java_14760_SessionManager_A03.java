public class java_14760_SessionManager_A03 {

    // A very simple session manager that uses a static map to store sessions.
    // This is not secure for a production system, as it doesn't handle concurrent access.

    private Map<String, Session> sessions;

    public java_14760_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        // Validate the session ID
        // This is a very simple validation and not for production use
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Get the session from the map
        Session session = sessions.get(sessionId);

        // If the session is not found, create a new one
        if (session == null) {
            session = new Session();
            session.setId(sessionId);

            // Store the session in the map
            sessions.put(sessionId, session);
        }

        return session;
    }

    public void closeSession(String sessionId) {
        // Validate the session ID
        // This is a very simple validation and not for production use
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        // Close the session from the map
        Session session = sessions.get(sessionId);
        if (session != null) {
            sessions.remove(sessionId);
        }
    }

    public static class Session {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}