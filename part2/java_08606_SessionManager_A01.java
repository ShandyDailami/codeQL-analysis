import java.util.HashMap;
import java.util.Map;

public class java_08606_SessionManager_A01 {
    // Define a HashMap to hold sessions
    private Map<String, String> sessionMap;

    // Initialize the session map
    public java_08606_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String getSession(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}