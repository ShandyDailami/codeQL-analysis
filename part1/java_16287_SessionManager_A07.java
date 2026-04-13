import java.util.HashMap;
import java.util.UUID;

public class java_16287_SessionManager_A07 {
    private HashMap<UUID, String> sessionMap;

    public java_16287_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String username) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, username);
        return sessionId.toString();
    }

    public String getUsername(String sessionId) {
        if (!sessionMap.containsKey(UUID.fromString(sessionId))) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(UUID.fromString(sessionId))) {
            throw new IllegalArgumentException("Invalid session ID");
        }
        sessionMap.remove(UUID.fromString(sessionId));
    }
}