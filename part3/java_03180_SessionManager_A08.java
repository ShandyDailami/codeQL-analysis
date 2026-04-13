import java.util.HashMap;
import java.util.Map;

public class java_03180_SessionManager_A08 {
    // Step 1: Define a class for our custom exception
    public static class SecurityException extends Exception {
        public java_03180_SessionManager_A08(String message) {
            super(message);
        }
    }

    // Step 2: Create a map to hold our sessions
    private Map<String, String> sessions = new HashMap<>();

    // Step 3: Create a method to create a session
    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        sessions.put(sessionId, username);
        return sessionId;
    }

    // Step 4: Create a method to validate a session
    public String validateSession(String sessionId) throws SecurityException {
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("Invalid session ID.");
        }
        return sessions.get(sessionId);
    }

    // Step 5: Create a method to invalidate a session
    public void invalidateSession(String sessionId) {
        sessions.remove(sessionId);
    }
}