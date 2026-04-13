import java.util.HashMap;
import java.util.Map;

public class java_26174_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_26174_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.getOrDefault(sessionId, null);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}