import java.util.HashMap;
import java.util.Map;

public class java_31990_SessionManager_A07 {
    // Create a private Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_31990_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    // Method to add a session
    public String addSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return null;
        }
        sessionMap.put(sessionId, "Session active");
        return sessionId;
    }

    // Method to remove a session
    public String removeSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return null;
        }
        return sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public String checkSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return null;
        }
        return sessionMap.get(sessionId);
    }
}