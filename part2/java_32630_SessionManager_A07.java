import java.util.HashMap;
import java.util.Map;

public class java_32630_SessionManager_A07 {
    // Create a map to store user sessions
    private Map<String, String> sessionMap;

    public java_32630_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the userId for a given session
    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}