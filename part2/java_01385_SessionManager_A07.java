import java.util.HashMap;
import java.util.Map;

public class java_01385_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_01385_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }

    public void validateSession(String userId, String sessionId) {
        if (!sessionMap.containsKey(userId) || !sessionMap.get(userId).equals(sessionId)) {
            throw new AuthFailureException("Invalid session ID or User ID");
        }
    }
}