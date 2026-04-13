import java.util.HashMap;
import java.util.Map;

public class java_00903_SessionManager_A07 {
    // A simple in-memory session storage
    private Map<String, String> sessionStorage = new HashMap<>();

    public void startSession(String sessionId, String userId) {
        // You should implement session validation here
        // For simplicity, we just store user ID in the session
        sessionStorage.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // You should implement session validation here
        // We return user ID from the session
        return sessionStorage.get(sessionId);
    }

    public void endSession(String sessionId) {
        // You should implement session validation here
        // Remove session from the storage
        sessionStorage.remove(sessionId);
    }
}