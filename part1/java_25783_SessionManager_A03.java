import java.util.HashMap;
import java.util.Map;

public class java_25783_SessionManager_A03 {
    // Create a HashMap to store session data
    private Map<String, String> sessionMap;

    public java_25783_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Add a new session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Remove an existing session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Check if a session is valid
    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}