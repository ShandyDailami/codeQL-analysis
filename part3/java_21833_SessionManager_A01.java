import java.util.HashMap;

public class java_21833_SessionManager_A01 {
    // A HashMap to store sessions
    private HashMap<String, String> sessions;

    public java_21833_SessionManager_A01() {
        // Initialize sessions HashMap
        sessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String username) {
        // Generate a unique session id
        String sessionId = String.valueOf(System.currentTimeMillis());
        // Store session id and username in the sessions HashMap
        sessions.put(sessionId, username);
        // Return the session id
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the sessions HashMap
        if (sessions.containsKey(sessionId)) {
            // Return the username associated with the session id
            return sessions.get(sessionId);
        } else {
            // Return null if the session id does not exist in the sessions HashMap
            return null;
        }
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session id from the sessions HashMap
        sessions.remove(sessionId);
    }
}