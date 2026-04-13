import java.util.HashMap;

public class java_24952_SessionManager_A08 {
    private HashMap<String, Session> sessions;

    public java_24952_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void createSession(String sessionId) {
        Session session = new Session();
        sessions.put(sessionId, session);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private class Session {
        // This is just a dummy session class. In a real-world application, session would contain more information like user id, created time, last accessed time, etc.
    }
}