import java.util.HashMap;
import java.util.UUID;

public class java_10971_SessionManager_A01 {
    private HashMap<UUID, String> sessionMap;

    public java_10971_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String startSession(String username) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, username);
        return sessionId.toString();
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(UUID.fromString(sessionId));
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(UUID.fromString(sessionId));
    }

    public void endSession(String sessionId) {
        sessionMap.remove(UUID.fromString(sessionId));
    }
}