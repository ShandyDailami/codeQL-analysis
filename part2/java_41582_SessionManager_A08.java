import java.util.HashMap;
import java.util.Map;

public class java_41582_SessionManager_A08 {

    // This is a simple in-memory store for session data
    private Map<String, String> sessionStore;

    public java_41582_SessionManager_A08() {
        this.sessionStore = new HashMap<>();
    }

    public String createSession(String userId) {
        // Generate a session id and save the user id in the session store
        String sessionId = generateSessionId();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    public String getUserIdFromSession(String sessionId) {
        // Retrieve the user id from the session store
        return sessionStore.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // Remove the session from the session store
        sessionStore.remove(sessionId);
    }

    // Simple session id generation for demonstration purposes
    private String generateSessionId() {
        return String.valueOf(System.currentTimeMillis());
    }
}