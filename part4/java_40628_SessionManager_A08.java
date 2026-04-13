import java.util.HashMap;
import java.util.Map;

public class java_40628_SessionManager_A08 {
    // A simple in-memory session store
    private Map<String, String> sessionStore;

    public java_40628_SessionManager_A08() {
        this.sessionStore = new HashMap<>();
    }

    // Create a session
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    // Get the user from the session
    public String getUserFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    // Delete the session
    public void deleteSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}