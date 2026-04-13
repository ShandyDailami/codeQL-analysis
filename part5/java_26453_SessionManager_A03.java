import java.util.HashMap;
import java.util.Map;

public class java_26453_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_26453_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        // Generate session id
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store username and session id in the map
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    public String getUsername(String sessionId) {
        // Retrieve the username based on session id
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}