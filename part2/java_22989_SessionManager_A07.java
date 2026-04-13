import java.util.HashMap;
import java.util.Map;

public class java_22989_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_22989_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method for authentication failure
    public void authenticateFailed(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            // In a real-world application, you might want to add some logic here to notify the user
            System.out.println("Authentication failed for user " + userId);
        }
    }
}