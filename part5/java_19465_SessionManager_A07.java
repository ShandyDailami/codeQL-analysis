import java.util.HashMap;
import java.util.Map;

public class java_19465_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_19465_SessionManager_A07() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // Generate a session ID and store it in sessions
        String sessionID = generateSessionID();
        sessions.put(sessionID, username);
    }

    public String getUsername(String sessionID) {
        // Retrieve the username from the sessions
        return sessions.get(sessionID);
    }

    public void endSession(String sessionID) {
        // Remove the session from the sessions
        sessions.remove(sessionID);
    }

    // Method to generate a session ID
    private String generateSessionID() {
        // This is a simple implementation, you might want to use UUIDs or similar
        // for a more secure and unique session ID
        return String.valueOf(System.currentTimeMillis());
    }
}