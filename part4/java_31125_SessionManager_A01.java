import java.util.HashMap;

public class java_31125_SessionManager_A01 {
    // Create a HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Default constructor
    public java_31125_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a unique session ID
        String sessionId = generateSessionId();

        // Store the session ID and username in the HashMap
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    // Method to validate a session
    public boolean validateSession(String sessionId, String expectedUsername) {
        // Check if the session ID is in the HashMap
        if (sessionMap.containsKey(sessionId)) {
            // If it is, check if the expected username matches the actual username
            if (sessionMap.get(sessionId).equals(expectedUsername)) {
                return true;
            }
        }
        return false;
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Remove the session ID from the HashMap
        sessionMap.remove(sessionId);
    }

    // Generate a unique session ID
    private String generateSessionId() {
        // Temporary session ID for demonstration
        return "A01_SESSION_ID";
    }
}