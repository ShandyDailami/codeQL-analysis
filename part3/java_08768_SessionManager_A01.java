import java.util.HashMap;
import java.util.Map;

public class java_08768_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_08768_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Security-sensitive operation: Access Control
    public void accessControl(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        if (userId != null && userId.equals(expectedUserId)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}