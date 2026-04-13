import java.util.HashMap;
import java.util.Map;

public class java_22346_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_22346_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        sessionMap.replace(sessionId, userId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}