import java.util.HashMap;
import java.util.Map;

public class java_22493_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22493_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newUserId) {
        if (isSessionValid(sessionId)) {
            deleteSession(sessionId);
            createSession(sessionId, newUserId);
        } else {
            // Handle integrity failure here
        }
    }
}