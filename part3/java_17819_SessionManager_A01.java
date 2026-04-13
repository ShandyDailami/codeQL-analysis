import java.util.HashMap;
import java.util.Map;

public class java_17819_SessionManager_A01 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_17819_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        String username = sessionMap.get(sessionId);
        if (username == null) {
            return "Invalid session";
        }
        return "Valid session";
    }

    // Method to end a session
    public String endSession(String sessionId) {
        sessionMap.remove(sessionId);
        return "Session ended";
    }

    // Method to change the username of a session
    public String changeUsername(String sessionId, String newUsername) {
        String username = sessionMap.get(sessionId);
        if (username == null) {
            return "Invalid session";
        }
        sessionMap.put(sessionId, newUsername);
        return "Username changed";
    }
}