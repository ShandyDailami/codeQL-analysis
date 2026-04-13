import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_02369_SessionManager_A07 {
    // Create a map to store sessions
    private Map<UUID, String> sessionMap;

    public java_02369_SessionManager_A07() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String username) {
        // Generate a unique ID for the session
        UUID uuid = UUID.randomUUID();

        // Store the session ID and username in the map
        sessionMap.put(uuid, username);

        // Return the session ID
        return uuid.toString();
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session ID from the map
        sessionMap.remove(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Check if the session ID is in the map
        return sessionMap.containsKey(sessionId);
    }
}