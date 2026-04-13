import java.util.HashMap;
import java.util.Map;

public class java_09091_SessionManager_A07 {
    private Map<String, String> sessions;

    public java_09091_SessionManager_A07() {
        this.sessions = new HashMap<>();
    }

    public void startSession(String sessionId, String userId) {
        if (sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session already exists");
        }

        sessions.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session not found");
        }

        return sessions.get(sessionId);
    }

    public void endSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            throw new RuntimeException("Session not found");
        }

        sessions.remove(sessionId);
    }
}