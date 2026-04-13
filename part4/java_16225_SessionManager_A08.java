import java.util.HashMap;
import java.util.Map;

public class java_16225_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_16225_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple method for generating session ids, you should use a secure method for a real-world application.
        return String.valueOf(System.currentTimeMillis());
    }
}