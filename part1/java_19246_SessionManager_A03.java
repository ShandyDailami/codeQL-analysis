import java.util.HashMap;

public class java_19246_SessionManager_A03 {
    // Using HashMap to store session IDs and their Session objects
    private HashMap<String, Session> sessionMap;

    // Default constructor
    public java_19246_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(Session session) {
        // Assign a new session ID to the session
        String sessionId = "A03_" + System.currentTimeMillis();
        sessionMap.put(sessionId, session);
        return sessionId;
    }

    // Method to get a session based on the session ID
    public Session getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to close a session based on the session ID
    public void closeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        }
    }
}