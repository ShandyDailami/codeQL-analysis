import java.util.HashMap;
import java.util.UUID;

public class java_02689_SessionManager_A03 {

    // A simple in-memory store for sessions
    private HashMap<String, String> sessionMap;

    // Constructor
    public java_02689_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession() {
        // Generate a new random UUID
        String sessionId = UUID.randomUUID().toString();

        // Store the session ID in the session map
        sessionMap.put(sessionId, "Logged In");

        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Invalid Session ID";
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }
}