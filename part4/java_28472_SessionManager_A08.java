import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_28472_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecureRandom secureRandom;

    public java_28472_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
        this.secureRandom = new SecureRandom();
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
        return String.valueOf(secureRandom.nextLong());
    }
}