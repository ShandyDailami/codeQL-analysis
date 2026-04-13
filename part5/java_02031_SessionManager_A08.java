import java.util.HashMap;
import java.util.Map;

public class java_02031_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_02031_SessionManager_A08() {
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

    public void checkSessionIntegrity(String sessionId, String expectedUserId) {
        String actualUserId = sessionMap.get(sessionId);

        if (actualUserId == null || !actualUserId.equals(expectedUserId)) {
            throw new SecurityException("Session integrity failure.");
        }
    }
}