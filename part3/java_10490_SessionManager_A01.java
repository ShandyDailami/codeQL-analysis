import java.util.HashMap;

public class java_10490_SessionManager_A01 {
    // A HashMap to store the sessions
    private HashMap<String, Session> sessions;

    public java_10490_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }

        Session session = new Session(sessionId);
        sessions.put(sessionId, session);

        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist with id: " + sessionId);
        }

        return sessions.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist with id: " + sessionId);
        }

        sessions.remove(sessionId);
    }
}

class Session {
    private String id;

    public java_10490_SessionManager_A01(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}