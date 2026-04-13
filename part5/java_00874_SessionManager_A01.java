import java.util.HashMap;
import java.util.UUID;

public class java_00874_SessionManager_A01 {
    // Create a private HashMap to store sessions
    private HashMap<UUID, String> sessionMap = new HashMap<>();

    // Create a method to create a new session
    public UUID createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    // Create a method to get a session data
    public String getSessionData(UUID sessionId) {
        return sessionMap.get(sessionId);
    }

    // Create a method to remove a session
    public void deleteSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}