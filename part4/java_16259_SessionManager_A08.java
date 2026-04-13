import java.util.HashMap;
import java.util.Map;

public class java_16259_SessionManager_A08 {

    // In-memory data store
    private Map<String, String> store;

    public java_16259_SessionManager_A08() {
        store = new HashMap<>();
    }

    // Method to create a session
    public String createSession(String userId) {
        // Generate a unique session id
        String sessionId = userId + System.currentTimeMillis();
        store.put(sessionId, userId);
        return sessionId;
    }

    // Method to validate a session
    public String validateSession(String sessionId) {
        // Check if the session id exists in the store
        if (store.containsKey(sessionId)) {
            return store.get(sessionId);
        } else {
            return null;
        }
    }

    // Method to remove a session
    public void removeSession(String sessionId) {
        // Remove the session from the store
        store.remove(sessionId);
    }
}