import java.util.HashMap;
import java.util.Map;

public class java_12831_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12831_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
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

    public boolean validateSession(String sessionId, String userId) {
        if (sessionMap.containsKey(sessionId)) {
            if (sessionMap.get(sessionId).equals(userId)) {
                return true;
            }
        }
        return false;
    }
}