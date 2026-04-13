import java.util.HashMap;
import java.util.UUID;

public class java_15149_SessionManager_A03 {

    private HashMap<UUID, String> sessions;

    public java_15149_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    // Method to start a session
    public UUID startSession(String sessionData) {
        UUID sessionID = UUID.randomUUID();
        sessions.put(sessionID, sessionData);
        return sessionID;
    }

    // Method to retrieve a session by its ID
    public String getSessionData(UUID sessionID) {
        if (sessions.containsKey(sessionID)) {
            return sessions.get(sessionID);
        } else {
            return null; // return null or throw exception if session doesn't exist
        }
    }

    // Method to close a session by its ID
    public void closeSession(UUID sessionID) {
        if (sessions.containsKey(sessionID)) {
            sessions.remove(sessionID);
        }
    }
}