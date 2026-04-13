import java.util.HashMap;

public class java_06176_SessionManager_A07 {

    // Create a HashMap to store user sessions
    private HashMap<String, String> sessions;

    // Constructor
    public java_06176_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    // Method to add a session
    public void addSession(String sessionId, String userId) {
        sessions.put(sessionId, userId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    // Method to validate a session
    public String getUserId(String sessionId) {
        return sessions.get(sessionId);
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessions.containsKey(sessionId);
    }

}