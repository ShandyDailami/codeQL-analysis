import java.util.HashMap;
import java.util.Map;

public class java_14186_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_14186_SessionManager_A01() {
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

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Generate a unique session id here. This is a simplified example.
        // In a real application, you should ensure that session ids are globally unique and long enough.
        return Long.toString(System.nanoTime(), 36);
    }
}