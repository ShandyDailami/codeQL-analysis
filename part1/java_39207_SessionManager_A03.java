import java.util.HashMap;
import java.util.Map;

public class java_39207_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_39207_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            // Validate session here, for example checking if the session ID is not null
            // Sanitize session ID for security here, for example by removing characters not allowed in session IDs
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}