import java.util.HashMap;
import java.util.Map;

public class java_05315_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05315_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // This is a security-sensitive operation for injection, as it could be used to overwrite or delete data.
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // This is a security-sensitive operation for injection, as it could be used to retrieve sensitive data.
        return sessionMap.get(sessionId);
    }
}