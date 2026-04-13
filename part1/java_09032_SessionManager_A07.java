import java.util.HashMap;
import java.util.Map;

public class java_09032_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_09032_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "active");
    }

    public void endSession(String userId) {
        sessionMap.put(userId, "inactive");
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    public void validateSession(String userId) {
        if (sessionMap.get(userId) == null) {
            throw new SecurityFailureException("Session not found for user: " + userId);
        }
    }
}