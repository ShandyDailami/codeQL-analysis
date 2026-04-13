import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_15517_SessionManager_A01 {
    private Map<UUID, String> sessions;

    public java_15517_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public String createSession(String username) {
        UUID sessionId = UUID.randomUUID();
        sessions.put(sessionId, username);
        return sessionId.toString();
    }

    public String getUsername(String sessionId) {
        return sessions.get(UUID.fromString(sessionId));
    }

    public boolean validateSession(String sessionId) {
        return sessions.containsKey(UUID.fromString(sessionId));
    }
}