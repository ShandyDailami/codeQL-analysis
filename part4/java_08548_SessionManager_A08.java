import java.util.HashMap;

public class java_08548_SessionManager_A08 {
    // Use a private HashMap to store session objects
    private HashMap<String, Session> sessions = new HashMap<>();

    // Session class
    public class Session {
        private String id;
        private boolean valid;

        public java_08548_SessionManager_A08(String id) {
            this.id = id;
            this.valid = true;
        }

        public void invalidate() {
            this.valid = false;
        }

        public boolean isValid() {
            return this.valid;
        }

        public String getId() {
            return this.id;
        }
    }

    // Method to create a new session
    public String createSession() {
        Session session = new Session(UUID.randomUUID().toString());
        sessions.put(session.getId(), session);
        return session.getId();
    }

    // Method to check if a session is valid
    public boolean checkSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null || !session.isValid()) {
            return false;
        }
        return true;
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session != null) {
            session.invalidate();
        }
    }
}