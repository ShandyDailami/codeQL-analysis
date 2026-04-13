import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class java_21898_SessionManager_A07 {
    private Map<String, String> sessionMap;
    private Random random;

    public java_21898_SessionManager_A07() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession(String username) {
        String sessionId;
        do {
            sessionId = randomSessionId();
        } while (sessionMap.containsKey(sessionId));

        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String randomSessionId() {
        return Long.toHexString(random.nextLong());
    }
}