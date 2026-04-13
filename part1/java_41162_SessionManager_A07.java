import java.util.HashMap;
import java.util.Map;

public class java_41162_SessionManager_A07 {

    // Using a HashMap to store the sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_41162_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}