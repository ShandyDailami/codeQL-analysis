import java.util.HashMap;
import java.util.Map;

public class java_06140_SessionManager_A01 {
    // Map to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_06140_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }
}