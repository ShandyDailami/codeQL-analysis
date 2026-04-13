import java.util.HashMap;
import java.util.Map;

public class java_27162_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_27162_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple example and should be replaced with a more secure mechanism
        // for generating session IDs.
        return String.valueOf(System.currentTimeMillis());
    }
}