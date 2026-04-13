import java.util.HashMap;
import java.util.Map;

public class java_17189_SessionManager_A01 {
    // A simple in-memory store for sessions
    private static Map<String, String> sessionStore;

    // Constructor
    public java_17189_SessionManager_A01() {
        this.sessionStore = new HashMap<>();
    }

    // Method to start a session
    public String startSession(String userId) {
        // Assign a session ID to the user
        String sessionId = userId + System.currentTimeMillis();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    // Method to get the user from a session
    public String getUserFromSession(String sessionId) {
        // Retrieve the user ID from the session store
        return sessionStore.get(sessionId);
    }

    // Method to end a session
    public void endSession(String sessionId) {
        // Remove the session from the session store
        sessionStore.remove(sessionId);
    }
}