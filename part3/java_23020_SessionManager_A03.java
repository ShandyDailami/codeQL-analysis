import java.util.HashMap;
import java.util.Map;

public class java_23020_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_23020_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String userId) {
        // Create a session id
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Get the user id from the session id
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}