import java.util.HashMap;
import java.util.Map;

public class java_23526_SessionManager_A03 {

    private Map<String, String> sessionMap;

    public java_23526_SessionManager_A03() {
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

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void validateSession(String sessionId, String expectedUserId) {
        if (!isSessionValid(sessionId)) {
            throw new IllegalStateException("Invalid session!");
        }

        String actualUserId = getUserIdFromSession(sessionId);
        if (!actualUserId.equals(expectedUserId)) {
            throw new IllegalStateException("Unauthorized access!");
        }
    }
}