import java.util.HashMap;
import java.util.Map;

public class java_00467_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_00467_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a unique session ID
        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Validate the session ID
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void removeSession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }
}