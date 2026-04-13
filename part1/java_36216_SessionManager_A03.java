import java.util.HashMap;
import java.util.Map;

public class java_36216_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_36216_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // Sensitive operation: store sensitive data
        sessionMap.put(sessionId, userId);
    }

    public String getSession(String sessionId) {
        // Sensitive operation: fetch sensitive data
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Sensitive operation: delete sensitive data
        sessionMap.remove(sessionId);
    }
}