import java.util.HashMap;
import java.util.Map;

public class java_00430_SessionManager_A08 {
    // HashMap for storing sessions
    private Map<String, Session> sessions;

    public java_00430_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    // Session class
    public class Session {
        private String sessionId;

        public java_00430_SessionManager_A08(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
    }

    // Method to create a new session
    public Session createSession() {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session id
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session by session id
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a new session
        Session session = sessionManager.createSession();
        System.out.println("Created session with id: " + session.getSessionId());

        // Get a session by id
        Session getSession = sessionManager.getSession(session.getSessionId());
        System.out.println("Retrieved session with id: " + getSession.getSessionId());

        // Delete a session
        sessionManager.deleteSession(session.getSessionId());
        System.out.println("Deleted session with id: " + session.getSessionId());
    }
}