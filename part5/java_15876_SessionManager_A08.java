import java.util.HashMap;
import java.util.Map;

public class java_15876_SessionManager_A08 {
    private Map<String, String> sessions;

    public java_15876_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String username) {
        // Create a session for the user
        // For simplicity, we're just creating a random string
        String sessionId = generateSessionId();
        sessions.put(sessionId, username);
        System.out.println("Started session for user " + username + " with ID " + sessionId);
    }

    public String getUsername(String sessionId) {
        // Retrieve the username from the session ID
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        // End the session by removing the username from the session
        String username = sessions.get(sessionId);
        if (username != null) {
            sessions.remove(sessionId);
            System.out.println("Ended session for user " + username + " with ID " + sessionId);
        }
    }

    // Helper method for generating a session ID
    private String generateSessionId() {
        // For simplicity, we're just creating a random string
        return UUID.randomUUID().toString();
    }
}