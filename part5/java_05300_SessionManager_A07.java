import java.util.*;

public class java_05300_SessionManager_A07 {
    // In-memory data structure to store user sessions.
    private Map<String, String> sessions = new HashMap<>();

    // Method to create a new session.
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to check if a session is valid.
    public boolean isValidSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

    // Method to get the user from a session.
    public String getUserFromSession(String sessionId) {
        if (!isValidSession(sessionId)) {
            throw new IllegalArgumentException("Invalid session");
        }
        return sessions.get(sessionId);
    }
}