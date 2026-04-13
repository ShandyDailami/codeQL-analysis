import java.util.HashMap;
import java.util.Map;

public class java_40411_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_40411_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailureException("Invalid session");
        }
    }
}