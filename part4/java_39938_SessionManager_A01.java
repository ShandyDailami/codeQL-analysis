import java.util.HashMap;
import java.util.Map;

public class java_39938_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_39938_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUserFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a very simple way to generate sessionId. In a real-world scenario,
        // you would want to use a more complex strategy to ensure uniqueness.
        return String.valueOf(System.currentTimeMillis());
    }
}