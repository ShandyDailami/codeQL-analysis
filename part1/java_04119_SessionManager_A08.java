import java.util.HashMap;
import java.util.Map;

public class java_04119_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04119_SessionManager_A08() {
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
}