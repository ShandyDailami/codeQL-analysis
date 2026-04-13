import java.util.HashMap;
import java.util.Map;

public class java_22360_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_22360_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Auxiliary methods to generate session ID and validate session ID
    private String generateSessionId() {
        // Generate a unique ID for each session. This is a simplistic approach and real-world applications would use UUIDs.
        return String.valueOf(System.currentTimeMillis());
    }

    private boolean validateSessionId(String sessionId) {
        // Implement session validation logic here. For example, check if the session ID exists in the session map.
        return sessionMap.containsKey(sessionId);
    }
}