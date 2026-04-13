import java.util.HashMap;
import java.util.Map;

public class java_02984_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_02984_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        if (sessionId == null || userId == null) {
            throw new IllegalArgumentException("Session ID and User ID must be provided");
        }

        if (sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session already exists with ID: " + sessionId);
        }

        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }

        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionId == null) {
            throw new IllegalArgumentException("Session ID must be provided");
        }

        if (!sessionMap.containsKey(sessionId)) {
            throw new IllegalStateException("Session does not exist with ID: " + sessionId);
        }

        sessionMap.remove(sessionId);
    }
}