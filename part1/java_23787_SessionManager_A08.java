import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_23787_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_23787_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }
}