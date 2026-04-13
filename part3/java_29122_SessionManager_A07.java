import java.util.HashMap;
import java.util.Map;

public class java_29122_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_29122_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        return userId != null && userId.equals(expectedUserId);
    }
}