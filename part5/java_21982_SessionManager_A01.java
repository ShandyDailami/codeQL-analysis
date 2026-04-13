import java.util.Map;
import java.util.UUID;

public class java_21982_SessionManager_A01 {
    private Map<UUID, String> sessionMap;

    public java_21982_SessionManager_A01() {
        sessionMap = new java.util.HashMap<>();
    }

    public void createSession(String userId) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, userId);
    }

    public String getUserIdFromSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void invalidateSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}