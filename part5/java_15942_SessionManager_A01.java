import java.util.HashMap;

public class java_15942_SessionManager_A01 {
    // A simple in-memory session store
    private HashMap<String, String> sessionStore = new HashMap<>();

    // A basic session manager that creates a session and stores it
    public String createSession(String userId) {
        String sessionId = userId + System.currentTimeMillis();
        sessionStore.put(sessionId, userId);
        return sessionId;
    }

    // A basic session manager that retrieves a userId given a sessionId
    public String getUserIdFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }

    // A basic session manager that validates a sessionId and returns true if it exists
    public boolean validateSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    // A basic session manager that destroys a session
    public void destroySession(String sessionId) {
        sessionStore.remove(sessionId);
    }
}