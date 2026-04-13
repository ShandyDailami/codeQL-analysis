import java.util.HashMap;
import java.util.Map;

public class java_28225_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_28225_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new RuntimeException("Session already exists for user: " + userId);
        }
        sessionMap.put(userId, "active");
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        sessionMap.put(userId, "inactive");
    }

    public String getSessionStatus(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        }
        return sessionMap.get(userId);
    }

    public void validateSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new RuntimeException("No session exists for user: " + userId);
        } else if (!"active".equals(sessionMap.get(userId))) {
            throw new RuntimeException("Session is inactive for user: " + userId);
        }
    }
}