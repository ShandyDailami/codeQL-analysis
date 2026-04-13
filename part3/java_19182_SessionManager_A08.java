public class java_19182_SessionManager_A08 {
    // This is a simple in-memory session store.
    // In a real-world scenario, it would use a database or a distributed cache.
    private Map<String, Session> sessions;

    public java_19182_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String id) {
        if (sessions.containsKey(id)) {
            throw new SessionExistsException("Session with id " + id + " already exists.");
        }

        Session session = new Session();
        session.id = id;
        sessions.put(id, session);

        return session;
    }

    public Session getSession(String id) {
        Session session = sessions.get(id);

        if (session == null) {
            throw new SessionNotFoundException("Session with id " + id + " not found.");
        }

        return session;
    }

    public void destroySession(String id) {
        Session session = sessions.remove(id);

        if (session == null) {
            throw new SessionNotFoundException("Session with id " + id + " not found.");
        }
    }

    // Session and related objects.
    public class Session {
        public String id;
        // Add other session-related properties here.
    }

    // Exception classes.
    public class SessionExistsException extends RuntimeException {
        public java_19182_SessionManager_A08(String message) {
            super(message);
        }
    }

    public class SessionNotFoundException extends RuntimeException {
        public java_19182_SessionManager_A08(String message) {
            super(message);
        }
    }
}