import java.util.HashMap;
import java.util.Map;

public class java_16813_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_16813_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userId, String sessionId) {
        sessionMap.put(userId, sessionId);
    }

    public String getSession(String userId) {
        return sessionMap.get(userId);
    }

    public void endSession(String userId) {
        sessionMap.remove(userId);
    }
}