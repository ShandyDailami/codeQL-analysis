import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_00082_SessionManager_A03 {
    // Define a HashMap to store session information
    private Map<String, String> sessionMap;

    // Constructor
    public java_00082_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession() {
        // Generate a unique ID for the session
        String sessionId = UUID.randomUUID().toString();

        // Store the session ID in the session map
        sessionMap.put(sessionId, "");

        // Return the session ID
        return sessionId;
    }

    // Method to validate a session
    public String getSession(String sessionId) {
        // Check if the session ID is in the session map
        if (sessionMap.containsKey(sessionId)) {
            // If the session ID is valid, return the session information
            return sessionMap.get(sessionId);
        } else {
            // If the session ID is not valid, return null
            return null;
        }
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Remove the session ID from the session map
        sessionMap.remove(sessionId);
    }
}