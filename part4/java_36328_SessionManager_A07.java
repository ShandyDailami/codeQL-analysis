import java.util.HashMap;
import java.util.Map;

public class java_36328_SessionManager_A07 {
    private static Map<String, String> sessionMap;

    // Initialization of the session map
    static {
        sessionMap = new HashMap<>();
    }

    // Method to create a session
    public static String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    // Method to destroy a session
    public static void destroySession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to validate a session
    public static void validateSession(String sessionId) throws Exception {
        // Simple authentication check
        if (!sessionMap.containsKey(sessionId)) {
            throw new Exception("Invalid session");
        }
    }

    public static void main(String[] args) {
        try {
            String userId = "user1";

            // Create a session
            String sessionId = createSession(userId);
            System.out.println("Session ID: " + sessionId);

            // Validate the session
            validateSession(sessionId);

            // Destroy the session
            destroySession(sessionId);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}