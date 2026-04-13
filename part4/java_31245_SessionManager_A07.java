import java.util.HashMap;

public class java_31245_SessionManager_A07 {
    // Initialize a HashMap to store user sessions
    private HashMap<String, String> userSessions;

    public java_31245_SessionManager_A07() {
        this.userSessions = new HashMap<>();
    }

    // Method to create a session for a user
    public String createSession(String username) {
        // Generate a random session ID
        String sessionId = generateSessionId();

        // Add the session ID to the HashMap
        userSessions.put(username, sessionId);

        return sessionId;
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Get the username from the session ID
        String username = userSessions.get(sessionId);

        // If the session ID is valid, return true
        return username != null;
    }

    // Method to get the username from a session
    public String getUsername(String sessionId) {
        // Return the username from the session ID
        return userSessions.get(sessionId);
    }

    // Method to generate a random session ID
    private String generateSessionId() {
        // Implement the logic to generate a random session ID
        return "SESSIONID_" + System.currentTimeMillis();
    }
}