import java.util.HashMap;

public class java_04530_SessionManager_A03 {
    // Create a new HashMap to store sessions
    private HashMap<String, String> sessionMap;

    // Constructor to initialize the sessionMap
    public java_04530_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a unique session ID
        String sessionId = generateSessionId();

        // Store the session ID and user ID in the session map
        sessionMap.put(sessionId, userId);

        return sessionId;
    }

    // Method to get the user ID for a given session ID
    public String getUserId(String sessionId) {
        // Get the user ID from the session map
        return sessionMap.get(sessionId);
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session from the session map
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a unique session ID
    private String generateSessionId() {
        // You could generate a UUID or some other unique ID here
        // For now, let's just use a simple counter
        static int counter = 0;
        counter++;
        return "session_" + counter;
    }
}