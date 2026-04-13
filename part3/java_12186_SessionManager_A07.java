import java.util.HashMap;
import java.util.UUID;

public class java_12186_SessionManager_A07 {
    private HashMap<UUID, String> sessionMap;

    public java_12186_SessionManager_A07() {
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
}