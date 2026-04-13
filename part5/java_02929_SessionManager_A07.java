import java.util.HashMap;
import java.util.UUID;

public class java_02929_SessionManager_A07 {
    // Create a HashMap to store session data
    private HashMap<UUID, String> sessionData = new HashMap<>();

    // Create a session
    public UUID createSession(String sessionData) {
        UUID sessionID = UUID.randomUUID();
        this.sessionData.put(sessionID, sessionData);
        return sessionID;
    }

    // Get session data
    public String getSessionData(UUID sessionID) {
        return this.sessionData.get(sessionID);
    }

    // Delete session
    public void deleteSession(UUID sessionID) {
        this.sessionData.remove(sessionID);
    }

    // Check if session exists
    public boolean sessionExists(UUID sessionID) {
        return this.sessionData.containsKey(sessionID);
    }
}