import java.util.HashMap;
import java.util.Map;

public class java_41824_SessionManager_A08 {
    // The actual session store
    private Map<String, String> sessionStore;

    // Default constructor
    public java_41824_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    // Method for starting a session
    public String startSession(String userId) {
        // Generate a unique session ID
        String sessionId = String.valueOf(System.currentTimeMillis());

        // Store the session ID and user ID in the store
        sessionStore.put(sessionId, userId);

        return sessionId;
    }

    // Method for ending a session
    public void endSession(String sessionId) {
        // Remove the session ID and user ID from the store
        sessionStore.remove(sessionId);
    }

    // Method for getting the user ID of a session
    public String getUserId(String sessionId) {
        // Return the user ID from the store
        return sessionStore.get(sessionId);
    }

    // Method to check if a session is valid
    public boolean isValidSession(String sessionId) {
        // Return whether the session ID is in the store
        return sessionStore.containsKey(sessionId);
    }
}