import java.util.HashMap;
import java.util.Map;

public class java_24339_SessionManager_A07 {

    private Map<String, String> sessions;

    public java_24339_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public String createSession(String user) {
        String sessionId = generateSessionId();
        sessions.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void destroySession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a simple implementation to generate session id. In a real-world scenario, you should use a secure method.
        return String.valueOf(System.currentTimeMillis());
    }
}