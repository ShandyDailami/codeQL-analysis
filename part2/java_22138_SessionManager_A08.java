import java.util.HashMap;
import java.util.UUID;

public class java_22138_SessionManager_A08 {
    private HashMap<UUID, String> sessionMap;

    public java_22138_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public UUID startSession(String user) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public String getUser(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}