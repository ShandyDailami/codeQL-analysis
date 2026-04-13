import java.util.HashMap;
import java.util.Map;

public class java_41998_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_41998_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserId) {
        String actualUserId = getUserIdFromSession(sessionId);
        if (!actualUserId.equals(expectedUserId)) {
            throw new SecurityFailureException("Session not validated for user " + actualUserId);
        }
    }
}