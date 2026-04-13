import java.util.HashMap;
import java.util.Map;

public class java_26592_SessionManager_A07 {
    // Create a HashMap to store sessions.
    private Map<String, String> sessions;

    // Constructor.
    public java_26592_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to create a new session.
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to get a user from a session.
    public String getUser(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to validate a session.
    public boolean validateSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}