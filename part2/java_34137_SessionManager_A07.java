import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class java_34137_SessionManager_A07 {
    private ConcurrentHashMap<UUID, String> sessionMap;

    public java_34137_SessionManager_A07() {
        sessionMap = new ConcurrentHashMap<>();
    }

    public String createSession(String userId) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userId);
        return sessionId.toString();
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public boolean sessionExists(String sessionId) {
        return sessionMap.containsKey(UUID.fromString(sessionId));
    }
}