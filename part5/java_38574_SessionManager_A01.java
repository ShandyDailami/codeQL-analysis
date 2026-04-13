import java.util.HashMap;
import java.util.Map;

public class java_38574_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38574_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}