import java.util.HashMap;
import java.util.Map;

public class java_35178_SessionManager_A07 {
    // Use a HashMap as a session storage
    private Map<String, String> sessionMap;

    public java_35178_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Create a session
    public String createSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
        return "Session created with ID: " + sessionId;
    }

    // Validate a session
    public String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return "Session validated. Username: " + sessionMap.get(sessionId);
        } else {
            return "Invalid session ID";
        }
    }

    // Delete a session
    public String deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "Session deleted with ID: " + sessionId;
        } else {
            return "Invalid session ID";
        }
    }
}