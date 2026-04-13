import java.util.HashMap;
import java.util.Map;

public class java_09860_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_09860_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Example of a security-sensitive operation, integrity failure:
    public boolean checkSessionIntegrity(String sessionId) {
        return sessions.containsKey(sessionId);
    }
}