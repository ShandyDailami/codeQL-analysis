import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_11729_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11729_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create a new session
    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Get session by id
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove session by id
    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}