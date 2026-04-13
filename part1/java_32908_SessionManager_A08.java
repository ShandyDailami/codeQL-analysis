import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_32908_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecureRandom random;

    public java_32908_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new SecureRandom();
    }

    public String createSession(String username) {
        String sessionId;
        do {
            sessionId = randomSessionId();
        } while (sessionMap.containsKey(sessionId));

        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsernameFromSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String randomSessionId() {
        return String.valueOf(random.nextLong() & Long.MAX_VALUE);
    }
}