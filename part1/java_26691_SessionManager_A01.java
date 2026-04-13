import java.util.HashMap;
import java.util.UUID;

public class java_26691_SessionManager_A01 {
    // A map to store sessions
    private HashMap<UUID, String> sessionMap;

    // Initializing the session map
    public java_26691_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public UUID createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    // Method to get session data
    public String getSessionData(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to check if a session exists
    public boolean checkSession(UUID sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}