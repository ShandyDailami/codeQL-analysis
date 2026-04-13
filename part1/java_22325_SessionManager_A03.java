import java.util.HashMap;

public class java_22325_SessionManager_A03 {
    private HashMap<String, String> sessionMap;

    public java_22325_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.isEmpty() || userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("Session ID and User ID must be non-empty strings");
        }

        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalArgumentException("Session already exists with ID: " + sessionId);
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be non-empty string");
        }

        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID must be non-empty string");
        }

        sessionMap.remove(sessionId);
    }
}