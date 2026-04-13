import java.util.HashMap;
import java.util.Map;

public class java_39689_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_39689_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a session ID generator.
        // In a real application, you would use UUID, server-side session management, etc.
        return "session_id_" + System.currentTimeMillis();
    }
}