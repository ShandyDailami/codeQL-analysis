import java.util.HashMap;
import java.util.Map;

public class java_35813_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_35813_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, userName);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // Here you can generate a random session ID or use a hash function.
        // For simplicity, let's just use a fixed session ID for this example.
        return "session123";
    }
}