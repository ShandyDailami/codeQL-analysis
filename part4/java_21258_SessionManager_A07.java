import java.util.HashMap;
import java.util.Map;

public class java_21258_SessionManager_A07 {
    // Create a HashMap for storing sessions
    private Map<String, String> sessionMap = new HashMap<>();

    // Create a method to create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Create a method to validate a session
    public String validateSession(String sessionId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null) {
            return userId;
        } else {
            return null;
        }
    }

    // Create a method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}