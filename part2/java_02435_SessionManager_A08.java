import java.util.HashMap;
import java.util.Map;

public class java_02435_SessionManager_A08 {
    // Create a Map to simulate the storage of sessions
    private Map<String, String> sessionMap;

    public java_02435_SessionManager_A08() {
        // Initialize the session map
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String user) {
        // Generate a session id and store in the map
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        // Retrieve the user from the map
        return sessionMap.get(sessionId);
    }

    // Method to destroy a session
    public void destroySession(String sessionId) {
        // Remove the session from the map
        sessionMap.remove(sessionId);
    }

    // Helper method to generate a session id
    private String generateSessionId() {
        // This is a simple way to generate a session id
        // In a real-world application, you'd want to use a more complex algorithm
        return String.valueOf(System.currentTimeMillis());
    }
}