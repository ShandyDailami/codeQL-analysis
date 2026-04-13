import java.util.HashMap;
import java.util.Map;

public class java_17336_SessionManager_A08 {
    // Create a private HashMap to store session data
    private Map<String, String> sessionMap;

    // Initialize the sessionMap
    public java_17336_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String user) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to get the user of a session
    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Generate a session ID
    private String generateSessionId() {
        // This is a simple example and may not be secure
        // In a real-world application, you should use a secure way to generate session IDs
        return String.valueOf(System.nanoTime());
    }
}