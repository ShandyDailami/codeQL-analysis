import java.util.HashMap;
import java.util.Map;

public class java_23842_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_23842_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String userId) {
        sessionMap.replace(sessionId, userId);
    }
}