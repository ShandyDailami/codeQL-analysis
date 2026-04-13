import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_26404_SessionManager_A07 {
    private Map<UUID, String> sessionMap;

    public java_26404_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        UUID uuid = UUID.randomUUID();
        sessionMap.put(uuid, userId);
        return uuid.toString();
    }

    public String getSession(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}