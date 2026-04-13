import java.util.HashMap;
import java.util.Map;

public class java_12539_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_12539_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId, String expectedUserId) {
        String userId = sessionMap.get(sessionId);
        if (userId == null) {
            return false;
        }

        if (!userId.equals(expectedUserId)) {
            deleteSession(sessionId);
            return false;
        }

        return true;
    }

}