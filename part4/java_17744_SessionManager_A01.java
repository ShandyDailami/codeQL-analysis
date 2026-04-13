import java.util.HashMap;

public class java_17744_SessionManager_A01 {

    // A HashMap to store sessions
    private HashMap<String, String> sessions;

    public java_17744_SessionManager_A01() {
        // Initialize sessions map
        sessions = new HashMap<>();
    }

    // Method to add a new session
    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to get the userId of a session
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }
}