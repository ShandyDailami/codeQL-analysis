import java.util.HashMap;
import java.util.Map;

public class java_39006_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_39006_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void destroyAllSessions() {
        sessionMap.clear();
    }
}