import java.util.HashMap;
import java.util.Map;

public class java_24120_SessionManager_A01 {

    // Using a HashMap as a simple session storage
    private Map<String, String> sessionMap;

    // Constructor
    public java_24120_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null && userId.equals(expectedUserId)) {
            return userId;
        }
        return null;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

}