import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_11488_SessionManager_A08 {
    private Map<String, String> sessions;
    private SecureRandom random;

    public java_11488_SessionManager_A08() {
        sessions = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionId;
        do {
            sessionId = generateSessionId();
        } while (sessions.containsValue(sessionId));
        sessions.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessions.getOrDefault(sessionId, null);
    }

    public void endSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private String generateSessionId() {
        return Long.toString(Math.abs(random.nextLong()), 36);
    }
}