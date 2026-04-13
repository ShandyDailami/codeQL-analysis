import java.util.HashMap;
import java.util.Map;

public class java_34946_SessionManager_A03 {

    // Map to hold the sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_34946_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString(); // Generate a random session ID
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // For simplicity, we just check if the session ID exists
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // Session ID not found
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}