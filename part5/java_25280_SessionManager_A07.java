import java.util.HashMap;
import java.util.Map;

public class java_25280_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_25280_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newUserId) {
        String userId = getUserIdFromSession(sessionId);
        endSession(sessionId);
        createSession(newUserId);
    }
}