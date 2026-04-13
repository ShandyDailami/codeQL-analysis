import java.util.HashMap;
import java.util.Map;

public class java_34104_SessionManager_A03 {

    private Map<String, String> sessionMap;

    // Constructor
    public java_34104_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Create Session
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Get Session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Destroy Session
    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}