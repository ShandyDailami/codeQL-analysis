import java.util.HashMap;
import java.util.Map;

public class java_17809_SessionManager_A07 {

    // Map to store sessions
    private Map<String, Session> sessions;

    // Constructor
    public java_17809_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to add a session
    public String addSession(Session session) {
        // Generate a unique session id
        String sessionId = generateSessionId();
        session.setSessionId(sessionId);
        sessions.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean sessionExists(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Helper method to generate a unique session id
    private String generateSessionId() {
        // This is a simple example, in a real application you'd probably want to use UUIDs
        // and make sure it's not already taken
        return String.valueOf(System.currentTimeMillis());
    }
}

class Session {
    private String sessionId;

    // Getters and setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}