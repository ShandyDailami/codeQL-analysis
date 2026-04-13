import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class java_11396_SessionManager_A01 {
    // A map to store sessions
    private Map<String, Session> sessions;

    // A random token generator
    private Random random;

    public java_11396_SessionManager_A01() {
        sessions = new HashMap<>();
        random = new Random();
    }

    // Method to start a new session
    public String startSession() {
        String sessionId = generateSessionId();
        Session session = new Session();
        sessions.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session by its ID
    public Session getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to close a session by its ID
    public void closeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }

    // Session class
    private class Session {
        // Session data
    }
}