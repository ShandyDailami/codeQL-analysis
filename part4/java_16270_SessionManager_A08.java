import java.util.HashMap;
import java.util.Map;

public class java_16270_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_16270_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityException("Session not found: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}