import java.util.HashMap;
import java.util.Map;

public class java_15108_SessionManager_A08 {
    private Map<String, String> sessionStore;

    public java_15108_SessionManager_A08() {
        sessionStore = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionStore.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists with id: " + sessionId);
        } else {
            sessionStore.put(sessionId, userId);
        }
    }

    public String getUserId(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist with id: " + sessionId);
        } else {
            return sessionStore.get(sessionId);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionStore.containsKey(sessionId)) {
            throw new RuntimeException("Session does not exist with id: " + sessionId);
        } else {
            sessionStore.remove(sessionId);
        }
    }

    public void invalidateSession(String sessionId) {
        endSession(sessionId);
    }
}