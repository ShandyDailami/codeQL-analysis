import java.util.HashMap;
import java.util.Map;

public class java_21182_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_21182_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public String getSessionId(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username should not be null or empty");
        }

        String sessionId = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionId, username);

        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session Id should not be null or empty");
        }

        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        if (sessionId == null || sessionId.trim().isEmpty()) {
            throw new IllegalArgumentException("Session Id should not be null or empty");
        }

        sessionMap.remove(sessionId);
    }
}