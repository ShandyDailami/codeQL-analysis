import java.util.HashMap;
import java.util.Map;

public class java_16507_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_16507_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a unique session ID and store it in the session map
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Retrieve the user ID from the session map
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}