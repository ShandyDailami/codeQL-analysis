import java.util.HashMap;
import java.util.Map;

public class java_01460_SessionManager_A01 {
    // A map to simulate a session storage. In real scenario, this would be a database or a real object
    private Map<String, String> sessionMap;

    // Constructor
    public java_01460_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        return "Session created with ID: " + sessionId;
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to validate a session (this is a security-sensitive operation)
    public boolean validateSession(String sessionId, String expectedUsername) {
        String username = sessionMap.get(sessionId);
        return username != null && username.equals(expectedUsername);
    }

    // Method to end a session (this is a security-sensitive operation)
    public String endSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        return "Session ended with ID: " + sessionId + " and username: " + username;
    }
}