import java.util.HashMap;
import java.util.Map;

public class java_06605_SessionManager_A01 {
    // Create a new HashMap to store sessions
    private Map<String, String> sessionMap;

    // Constructor
    public java_06605_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String sessionKey) {
        // Check if sessionKey is null or empty
        if (sessionKey == null || sessionKey.isEmpty()) {
            System.out.println("Session key is not valid");
            return null;
        }

        // Generate a session ID
        String sessionId = generateSessionId();

        // Store the session ID and session key in the session map
        sessionMap.put(sessionId, sessionKey);

        return sessionId;
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            System.out.println("Session ID is not valid");
            return null;
        }

        // Check if the session ID exists in the session map
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist");
            return null;
        }

        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        // Check if sessionId is null or empty
        if (sessionId == null || sessionId.isEmpty()) {
            System.out.println("Session ID is not valid");
            return;
        }

        // Check if the session ID exists in the session map
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Session ID does not exist");
            return;
        }

        // Remove the session ID from the session map
        sessionMap.remove(sessionId);
    }

    // Method to generate a session ID
    private String generateSessionId() {
        // This is a simple example, you can use UUID, SecureRandom, etc.
        // for a real-world application, it should be more secure
        return String.valueOf(System.currentTimeMillis());
    }
}