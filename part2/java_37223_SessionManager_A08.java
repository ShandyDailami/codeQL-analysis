import java.util.HashMap;
import java.util.Map;

public class java_37223_SessionManager_A08 {

    // A simple in-memory session store.
    private Map<String, String> sessionStore;

    public java_37223_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        sessionStore.put(sessionId, userId);
    }

    public void endSession(String sessionId) {
        sessionStore.remove(sessionId);
    }

    public String getUserId(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
        return sessionStore.get(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionStore.containsKey(sessionId);
    }

    public void invalidateSession(String sessionId) {
        endSession(sessionId);
    }

    public void checkSessionIntegrity() {
        for (Map.Entry<String, String> entry : sessionStore.entrySet()) {
            if (!isValidSession(entry.getKey())) {
                throw new SecurityException("Session integrity failure: " + entry.getKey());
            }
        }
    }
}