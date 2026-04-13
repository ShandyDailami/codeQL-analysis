import java.util.HashMap;
import java.util.Map;

public class java_33963_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_33963_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}