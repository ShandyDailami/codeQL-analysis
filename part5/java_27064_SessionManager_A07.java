import java.util.HashMap;
import java.util.Map;

public class java_27064_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_27064_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}