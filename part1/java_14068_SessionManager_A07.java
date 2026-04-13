import java.util.HashMap;
import java.util.Map;

public class java_14068_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_14068_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return System.currentTimeMillis() + "_" + Math.random() + "_" + Thread.currentThread().getId();
    }
}