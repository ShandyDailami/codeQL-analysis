import java.util.HashMap;
import java.util.UUID;

public class java_17635_SessionManager_A07 {

    // Create a HashMap to store session data
    private HashMap<UUID, String> sessionMap;

    public java_17635_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public UUID createSession(String username) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // Method to get the username for a given session ID
    public String getUsername(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to invalidate a session
    public void invalidateSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}