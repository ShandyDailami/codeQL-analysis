import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_15824_SessionManager_A08 {
    private final SecureRandom secureRandom = new SecureRandom();
    private Map<String, Long> sessionIdToLastAccess = new HashMap<>();

    public String generateSessionId() {
        String sessionId;
        do {
            sessionId = new String(new byte[10], secureRandom);
        } while (sessionIdExists(sessionId));

        return sessionId;
    }

    private boolean sessionIdExists(String sessionId) {
        return sessionIdToLastAccess.containsKey(sessionId);
    }

    public void accessSession(String sessionId) {
        if (!sessionIdExists(sessionId)) {
            sessionIdToLastAccess.put(sessionId, System.currentTimeMillis());
        } else {
            sessionIdToLastAccess.remove(sessionId);
        }
    }
}