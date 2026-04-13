import java.util.HashMap;
import java.util.Map;

public class java_10672_SessionManager_A07 {
    // A map to store session objects.
    private Map<String, Session> sessionMap;

    // Constructor.
    public java_10672_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session.
    public Session createSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("A session with this ID already exists.");
        }

        Session session = new Session(sessionId);
        sessionMap.put(sessionId, session);

        return session;
    }

    // Method to retrieve a session.
    public Session getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with this ID exists.");
        }

        return sessionMap.get(sessionId);
    }

    // Method to close a session.
    public void closeSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session with this ID exists.");
        }

        sessionMap.remove(sessionId);
    }
}