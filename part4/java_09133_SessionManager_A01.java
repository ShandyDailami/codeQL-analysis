import java.util.HashMap;
import java.util.Map;

public class java_09133_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_09133_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId, String username) {
        if (sessionId == null || sessionId.trim().isEmpty() || username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID and Username must not be null or empty");
        }
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        sessionMap.remove(sessionId);
    }
}