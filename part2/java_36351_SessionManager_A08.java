import java.util.HashMap;
import java.util.Map;

public class java_36351_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_36351_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = userId + System.currentTimeMillis();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        // Validate the integrity of the session
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new SecurityFailureException("Invalid session");
        }
    }
}