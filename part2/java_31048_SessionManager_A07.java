import java.util.HashMap;
import java.util.Map;

public class java_31048_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31048_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean validateSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        deleteSession(sessionId);
    }
}