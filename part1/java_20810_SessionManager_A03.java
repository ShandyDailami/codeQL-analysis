import java.util.HashMap;
import java.util.Map;

public class java_20810_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_20810_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.isEmpty() || userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("Session ID and User ID must be provided");
        }

        // Check if session is already started
        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already started for user: " + userId);
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserIdForSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        // Check if session is started
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session started for user");
        }

        return sessionMap.get(sessionId);
    }

    public void stopSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        // Check if session is started
        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("No session started for user");
        }

        sessionMap.remove(sessionId);
    }
}