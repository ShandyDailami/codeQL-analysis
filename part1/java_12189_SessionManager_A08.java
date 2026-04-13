import java.util.HashMap;
import java.util.Map;

public class java_12189_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_12189_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            throw new SecurityException("Session already started for user: " + userId);
        }
        sessionMap.put(userId, "active");
    }

    public void endSession(String userId) {
        if (!sessionMap.containsKey(userId)) {
            throw new SecurityException("No session started for user: " + userId);
        }
        sessionMap.put(userId, "inactive");
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }
}