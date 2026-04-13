import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_08457_SessionManager_A08 {
    private Map<UUID, String> sessionMap;

    public java_08457_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String data) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, data);
        return sessionId.toString();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void validateSession(String sessionId) {
        if (!sessionMap.containsKey(UUID.fromString(sessionId))) {
            throw new SecurityFailureException("Invalid session ID");
        }
    }

    public void expireSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public void lockSession(String sessionId) {
        // Simple locking mechanism for demonstration purposes
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unlockSession(String sessionId) {
        // No locking mechanism for demonstration purposes
    }
}