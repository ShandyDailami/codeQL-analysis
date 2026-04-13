import java.util.HashMap;

public class java_39214_SessionManager_A08 {
    // HashMap to store sessions
    private HashMap<String, Session> sessions;

    // Constructor
    public java_39214_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            System.out.println("Session already exists: " + sessionId);
            return null;
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Session not found: " + sessionId);
            return null;
        }
        return sessions.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            System.out.println("Session not found: " + sessionId);
            return;
        }
        sessions.remove(sessionId);
        System.out.println("Session invalidated: " + sessionId);
    }

    // Session class
    class Session {
        private String sessionId;

        public java_39214_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }
}