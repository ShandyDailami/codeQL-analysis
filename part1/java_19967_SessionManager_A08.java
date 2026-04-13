import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class java_19967_SessionManager_A08 {
    private static final SecureRandom random = new SecureRandom();
    private Map<String, String> sessionStore;

    public java_19967_SessionManager_A08() {
        this.sessionStore = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId;
        do {
            sessionId = randomSessionId();
        } while (sessionStore.containsKey(sessionId));
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    private String randomSessionId() {
        return String.valueOf(random.nextLong() + System.nanoTime());
    }
}