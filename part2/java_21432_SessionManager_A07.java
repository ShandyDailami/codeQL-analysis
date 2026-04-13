import java.util.HashMap;
import java.util.UUID;

public class java_21432_SessionManager_A07 {
    private HashMap<UUID, String> sessionMap;

    public java_21432_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userName) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userName);
        return sessionId.toString();
    }

    public String getSessionUser(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public void invalidateSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}