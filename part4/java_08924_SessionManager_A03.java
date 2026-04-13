import java.util.HashMap;

public class java_08924_SessionManager_A03 {
    // The session store
    private HashMap<String, String> sessionStore = new HashMap<>();

    // Start a session
    public String startSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    // Get user from session
    public String getUserFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    // End a session
    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}