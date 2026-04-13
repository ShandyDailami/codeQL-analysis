import java.util.HashMap;
import java.util.Map;

public class java_37607_SessionManager_A03 {
    // Create a HashMap to store sessions
    private Map<String, String> sessionMap;

    public java_37607_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to retrieve the user from a session
    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}