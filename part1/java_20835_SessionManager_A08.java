import java.util.HashMap;

public class java_20835_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_20835_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Auxiliary methods
    private String generateSessionId() {
        // This is a simple implementation for the sake of example.
        // It's not recommended to use this in a real-world application.
        return Long.toString(System.nanoTime(), 36);
    }
}