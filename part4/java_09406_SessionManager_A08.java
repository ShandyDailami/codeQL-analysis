import java.util.HashMap;
import java.util.Map;

public class java_09406_SessionManager_A08 {
    // A map to store user sessions.
    private Map<String, String> sessionMap;

    public java_09406_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session for a user.
    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a session.
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session.
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Generate a random session ID.
    private String generateSessionId() {
        // This is a simplistic way to generate session IDs. In a real-world
        // application, you would likely use a UUID or some other unique identifier.
        return String.valueOf(System.currentTimeMillis());
    }
}