import java.util.HashMap;
import java.util.Map;

public class java_24526_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_24526_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }

        String sessionId = sessionMap.get(username);
        if (sessionId == null) {
            sessionId = UUID.randomUUID().toString();
            sessionMap.put(username, sessionId);
        }

        return sessionId;
    }

    public void invalidateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new IllegalArgumentException("Session ID cannot be null or empty");
        }

        String username = sessionMap.get(sessionId);
        if (username == null) {
            throw new IllegalStateException("Session ID does not exist");
        }

        sessionMap.remove(sessionId);
    }
}