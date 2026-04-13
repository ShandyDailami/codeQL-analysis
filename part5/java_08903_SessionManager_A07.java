import java.util.HashMap;
import java.util.Map;

public class java_08903_SessionManager_A07 {
    // Using a HashMap to store sessions
    private Map<String, String> sessionMap = new HashMap<>();

    // Session creation
    public String createSession(String userId) {
        // Generate a session id, this is just for demonstration
        String sessionId = "session_" + userId;
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Session retrieval
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Session deletion
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}