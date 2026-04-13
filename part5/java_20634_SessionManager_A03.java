import java.util.HashMap;
import java.util.Map;

public class java_20634_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20634_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}