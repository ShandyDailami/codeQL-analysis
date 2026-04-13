import java.util.HashMap;
import java.util.Map;

public class java_22395_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_22395_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateUserSession(String sessionId, String expectedUserId) {
        if (!isValidSession(sessionId)) {
            throw new IllegalArgumentException("Invalid session ID");
        }

        String currentUserId = getUserId(sessionId);
        if (!currentUserId.equals(expectedUserId)) {
            throw new SecurityException("Invalid user ID");
        }
    }
}