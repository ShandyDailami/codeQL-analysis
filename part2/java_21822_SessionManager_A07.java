import java.util.HashMap;
import java.util.Map;

public class java_21822_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_21822_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public boolean isValidSession(String sessionId, String expectedUserId) {
        if (!isSessionActive(sessionId)) {
            return false;
        }
        String actualUserId = getUserIdFromSession(sessionId);
        return actualUserId.equals(expectedUserId);
    }

}