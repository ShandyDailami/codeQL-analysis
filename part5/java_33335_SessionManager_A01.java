import java.util.HashMap;
import java.util.Map;

public class java_33335_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_33335_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}