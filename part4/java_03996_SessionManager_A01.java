import java.util.HashMap;

public class java_03996_SessionManager_A01 {
    private HashMap<String, Session> sessions;

    public java_03996_SessionManager_A01() {
        this.sessions = new HashMap<>();
    }

    public Session createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        }
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session exists with id: " + sessionId);
        }
        return session;
    }

    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new RuntimeException("No session exists with id: " + sessionId);
        }
        sessions.remove(sessionId);
    }
}