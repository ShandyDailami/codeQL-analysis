import java.util.HashMap;
import java.util.Map;

public class java_12269_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_12269_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null; // Return null if session is not found
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}