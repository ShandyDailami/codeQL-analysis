import java.util.HashMap;
import java.util.Map;

public class java_12379_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12379_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void deleteUser(String userId) {
        // Implement security-sensitive operation related to A01_BrokenAccessControl
        // This operation can be done by invalidating the session for the user
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            if (entry.getValue().equals(userId)) {
                destroySession(entry.getKey());
            }
        }
    }
}