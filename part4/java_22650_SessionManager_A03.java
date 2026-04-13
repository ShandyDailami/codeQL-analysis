import java.util.HashMap;

public class java_22650_SessionManager_A03 {
    // Use a HashMap to store sessions.
    private HashMap<String, String> sessions = new HashMap<>();

    // Constructor
    public java_22650_SessionManager_A03() {
        // Initialize the session map.
        sessions.put("session1", "User1");
        sessions.put("session2", "User2");
        sessions.put("session3", "User3");
    }

    // Method to get a session.
    public String getSession(String sessionId) {
        // Check if the session exists.
        if (sessions.containsKey(sessionId)) {
            return sessions.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to set a session.
    public void setSession(String sessionId, String user) {
        // Set the session.
        sessions.put(sessionId, user);
    }

    // Method to remove a session.
    public void removeSession(String sessionId) {
        // Remove the session.
        sessions.remove(sessionId);
    }
}