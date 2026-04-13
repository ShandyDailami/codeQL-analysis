import java.util.HashMap;
import java.util.Map;

public class java_19545_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_19545_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}