import java.util.HashMap;
import java.util.Map;

public class java_23768_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_23768_SessionManager_A03() {
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

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserId) {
        if (!isValidSession(sessionId)) {
            throw new SecurityException("Invalid session id!");
        }

        String actualUserId = getUserId(sessionId);

        if (!actualUserId.equals(expectedUserId)) {
            throw new SecurityException("Unauthorized access!");
        }
    }
}