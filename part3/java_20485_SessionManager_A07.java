import java.util.HashMap;
import java.util.Map;

public class java_20485_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_20485_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new IllegalStateException("Session already exists for user: " + userId);
        }
        sessionMap.put(userId, "active");
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        sessionMap.put(userId, "inactive");
    }

    public String getSessionStatus(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        return sessionMap.get(userId);
    }

    public void authFailure(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new IllegalStateException("No session exists for user: " + userId);
        }
        if ("active".equals(sessionMap.get(userId))) {
            throw new IllegalStateException("Auth failure for user: " + userId);
        }
    }
}