import java.util.HashMap;
import java.util.UUID;

public class java_41873_SessionManager_A03 {
    private HashMap<UUID, String> sessionMap;

    public java_41873_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public UUID createSession(String userData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, userData);
        return sessionId;
    }

    // Method to access data in a session
    public String accessSession(UUID sessionId) {
        String userData = sessionMap.get(sessionId);
        // Security-sensitive operation: print user data
        System.out.println("Accessing data in session: " + userData);
        return userData;
    }

    // Method to remove a session
    public void removeSession(UUID sessionId) {
        sessionMap.remove(sessionId);
    }
}