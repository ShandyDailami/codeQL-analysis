import java.util.HashMap;

public class java_33557_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_33557_SessionManager_A08() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (sessions.containsKey(sessionId)) {
            throw new SecurityException("A session with the ID " + sessionId + " already exists");
        }
        sessions.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }
        if (!sessions.containsKey(sessionId)) {
            throw new SecurityException("No session with the ID " + sessionId + " exists");
        }
        sessions.remove(sessionId);
    }
}