import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class java_27996_SessionManager_A01 {
    // Create a new ConcurrentHashMap to store session data
    private Map<String, Session> sessions;

    public java_27996_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
    }

    // Method to create a new session
    public Session createSession(String sessionId) {
        Session session = new Session(sessionId);
        sessions.put(sessionId, session);
        return session;
    }

    // Method to get a session
    public Session getSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found for id: " + sessionId);
        }
        return session;
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (session == null) {
            throw new IllegalStateException("No session found for id: " + sessionId);
        }
        sessions.remove(sessionId);
    }
}