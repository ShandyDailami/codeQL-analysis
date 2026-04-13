import java.util.HashMap;

public class java_23258_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_23258_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            // Handle duplicate session
            return null;
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_23258_SessionManager_A08(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    // Add methods for integrity failure here
    public void setId(String id) {
        // Set id and check for integrity failure
        this.id = id;
    }
}