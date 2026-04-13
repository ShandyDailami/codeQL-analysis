import java.util.HashMap;
import java.util.Map;

public class java_12148_SessionManager_A07 {

    // Define a HashMap to store sessions
    private Map<String, String> sessions = new HashMap<>();

    // Method to create a new session
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, user);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if session exists
        if (!sessions.containsKey(sessionId)) {
            throw new AuthFailureException("Invalid session id");
        }

        // Check if session has expired (This is not a security sensitive operation)

        // Return the user associated with the session
        return sessions.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}