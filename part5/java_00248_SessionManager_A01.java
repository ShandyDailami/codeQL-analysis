import java.util.HashMap;
import java.util.Map;

public class java_00248_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_00248_SessionManager_A01() {
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

    public void checkAndProtectAccess(String sessionId, String expectedUserId) {
        if (!isSessionActive(sessionId)) {
            throw new BrokenAccessException("Session is inactive!");
        }

        String currentUserId = getUserIdFromSession(sessionId);
        if (!currentUserId.equals(expectedUserId)) {
            throw new BrokenAccessException("Access Denied!");
        }
    }
}