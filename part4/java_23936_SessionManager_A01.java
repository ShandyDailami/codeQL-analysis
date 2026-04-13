import java.util.HashMap;
import java.util.Map;

public class java_23936_SessionManager_A01 {
    // Create a map to store sessions
    private Map<String, String> sessionMap;

    public java_23936_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userId) {
        // For now, we'll just store user ID in the session map
        sessionMap.put(userId, userId);
        return userId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if session exists in session map
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    // Method to invalidate a session
    public void invalidateSession(String sessionId) {
        // Invalidate session by removing it from the session map
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        // Create a session
        String userId = sessionManager.createSession("123");
        System.out.println("Created session: " + userId);

        // Validate the session
        String validatedUserId = sessionManager.validateSession(userId);
        if (validatedUserId != null) {
            System.out.println("Validated session: " + validatedUserId);
        } else {
            System.out.println("Invalid session");
        }

        // Invalidate the session
        sessionManager.invalidateSession(userId);
        System.out.println("Invalidated session: " + userId);
    }
}