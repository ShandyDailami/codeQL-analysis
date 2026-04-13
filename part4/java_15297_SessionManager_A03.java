import java.util.HashMap;
import java.util.UUID;

public class java_15297_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_15297_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Add a new session
    public UUID addSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    // Get a session by ID
    public String getSession(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    // Remove a session by ID
    public void removeSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}