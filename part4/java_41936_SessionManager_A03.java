import java.util.HashMap;

public class java_41936_SessionManager_A03 {
    // Store of sessions
    private HashMap<String, String> sessionStore;

    public java_41936_SessionManager_A03() {
        sessionStore = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Generate a random session id
        String sessionId = generateSessionId();

        // Store the session id and user id
        sessionStore.put(sessionId, userId);

        return sessionId;
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session id from the store
        sessionStore.remove(sessionId);
    }

    // Method to get the user id from a session
    public String getUserId(String sessionId) {
        // Return the user id from the store
        return sessionStore.get(sessionId);
    }

    // Method to generate a random session id
    private String generateSessionId() {
        // Implementation depends on your needs, this is a simple example
        return String.valueOf(System.currentTimeMillis());
    }
}