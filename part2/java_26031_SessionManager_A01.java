import java.util.HashMap;
import java.util.Map;

public class java_26031_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_26031_SessionManager_A01() {
        userMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId(); // This will be a unique identifier for each session
        userMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return userMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        userMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation and should be replaced with a more secure mechanism
        return String.valueOf(System.currentTimeMillis());
    }
}