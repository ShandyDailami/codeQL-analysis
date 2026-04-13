import java.util.HashMap;

public class java_31773_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_31773_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        if (!isValidSessionId(sessionId)) {
            System.out.println("Invalid session ID: " + sessionId);
            return null;
        }

        Session session = sessions.get(sessionId);
        if (session == null) {
            System.out.println("No session found for session ID: " + sessionId);
            return null;
        }

        if (!session.isActive()) {
            System.out.println("Session is not active for session ID: " + sessionId);
            return null;
        }

        return session;
    }

    private boolean isValidSessionId(String sessionId) {
        // Insert your implementation here for checking the validity of the sessionId
        // For example, check if the sessionId is not null and if it's a valid UUID
        // If all checks pass, return true, otherwise return false
        return true;
    }

    private class Session {
        private String id;
        private boolean active;

        public java_31773_SessionManager_A01(String id) {
            this.id = id;
            this.active = true;
        }

        public String getId() {
            return id;
        }

        public boolean isActive() {
            return active;
        }

        public void close() {
            active = false;
        }
    }
}