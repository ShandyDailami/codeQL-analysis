import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_32092_SessionManager_A08 {
    private Map<UUID, String> sessionMap;

    public java_32092_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, user);
        return sessionId.toString();
    }

    public String getUser(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(UUID.fromString(sessionId));
    }
}